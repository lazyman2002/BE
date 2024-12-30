package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.model.Groups;
import proto.ServerChat;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HadoopService {
    private static final String TABLE_MSG = "Messengers";
    private static final String COLUMN_FAMILY = "info";
    private Configuration config;

    public HadoopService(){
        config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "172.18.0.7");
        config.set("hbase.zookeeper.property.clientPort", "2181");
    }

    public void saveGroupData(ServerChat.MessageInfo request) throws Exception {
        try (Connection connection = ConnectionFactory.createConnection(config)) {
            Table table = connection.getTable(TableName.valueOf(TABLE_MSG));

            String rowKey = request.getToGroupID() + "-" + request.getMsgID();
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("fromUserID"), Bytes.toBytes(request.getFromUserID()));
            put.addColumn(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("msgID"), Bytes.toBytes(request.getMsgID()));
            put.addColumn(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("messengerData"), Bytes.toBytes(request.getMessengerData()));
            table.put(put);
        } catch (Exception e) {
            System.err.println("Error saving data to HBase: " + e.getMessage());
            throw e;
        }
    }

    public List<ServerChat.MessageInfo> getMessagesByGroupID(Integer toGroupID) throws Exception {
        List<ServerChat.MessageInfo> messages = new ArrayList<>();
        try (Connection connection = ConnectionFactory.createConnection(config)) {
            Table table = connection.getTable(TableName.valueOf(TABLE_MSG));
            Scan scan = new Scan();

            String startRow = toGroupID + "-";
            String stopRow = toGroupID + "-~";
            scan.withStartRow(Bytes.toBytes(startRow));
            scan.withStopRow(Bytes.toBytes(stopRow));

            scan.addFamily(Bytes.toBytes(COLUMN_FAMILY));
            scan.addColumn(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("msgID"));
            scan.addColumn(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("fromUserID"));
            scan.addColumn(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("messengerData"));

            ResultScanner scanner = table.getScanner(scan);
            for (Result result : scanner) {
                System.out.println("Result found");
                byte[] msgIDBytes = result.getValue(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("msgID"));
                Integer msgID = msgIDBytes != null ? Bytes.toInt(msgIDBytes) : null;
                System.out.println("msgID: " + (msgID != null ? msgID : "null"));

                byte[] fromUserIDBytes = result.getValue(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("fromUserID"));
                Integer fromUserID = fromUserIDBytes != null ? Bytes.toInt(fromUserIDBytes) : null;
                System.out.println("fromUserID: " + (fromUserID != null ? fromUserID : "null"));

                byte[] messengerDataBytes = result.getValue(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("messengerData"));
                String messengerData = messengerDataBytes != null ? Bytes.toString(messengerDataBytes) : "null";
                System.out.println("messengerData: " + messengerData);

                ServerChat.MessageInfo.Builder builder = ServerChat.MessageInfo.newBuilder();
                builder.setMsgID((msgID));
                builder.setFromUserID(fromUserID);
                builder.setToGroupID(toGroupID);
                builder.setMessengerData(messengerData);
                messages.add(builder.build());
            }
        }
        return messages;
    }

    public ArrayList<Groups> sortBySendTime(ArrayList<Groups> request) throws Exception{
        ArrayList<Groups> temp = new ArrayList<>(request);
        try (Connection connection = ConnectionFactory.createConnection(config)) {
            Table table = connection.getTable(TableName.valueOf(TABLE_MSG));
            List<Integer> groupIDs = request.stream()
                    .map(Groups::getGroupID)
                    .collect(Collectors.toList());
            Map<Integer, Long> groupIDToTimestampMap = new HashMap<>();

            groupIDs.forEach(groupID -> {
                String prefix = groupID+"-";
                Scan scan = new Scan();
                scan.setReversed(true);
                scan.setMaxResultSize(1);

                PrefixFilter prefixFilter = new PrefixFilter(Bytes.toBytes(prefix));
                scan.setFilter(prefixFilter);

                scan.addFamily(Bytes.toBytes(COLUMN_FAMILY));
                scan.addColumn(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("messengerData"));
                try {
                    System.out.println("Scanning for groupID: "+prefix);
                    ResultScanner scanner = table.getScanner(scan);
                    for (Result result : scanner) {
                        System.out.println("Result found "+ prefix);
                        List<Cell> cells = result.listCells();
                        for (Cell cell : cells) {
                            long writeTimestamp = cell.getTimestamp();
                            groupIDToTimestampMap.put(groupID, writeTimestamp);
                        }
                    }
                    System.out.println("Scanner closed");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            List<Integer> sortedGroupIDs = new ArrayList<>(groupIDToTimestampMap.keySet());
            sortedGroupIDs.sort(Comparator.comparingLong(groupIDToTimestampMap::get).reversed());
            temp.sort(Comparator.comparingLong(group -> sortedGroupIDs.indexOf(group.getGroupID())));
            connection.close();
            return temp;
        }
        catch (Exception e){
            throw new Exception(e);
        }
    }
}