package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import proto.ServerChat;

import java.util.ArrayList;
import java.util.List;

public class HadoopService {
    private static final String TABLE_NAME = "Messengers";
    private static final String COLUMN_FAMILY = "info";

    public void saveGroupData(ServerChat.MessageInfo request) throws Exception {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "localhost");
        config.set("hbase.zookeeper.property.clientPort", "2181");

        try (Connection connection = ConnectionFactory.createConnection(config)) {
            Table table = connection.getTable(TableName.valueOf(TABLE_NAME));

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
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "localhost");
        config.set("hbase.zookeeper.property.clientPort", "2181");

        List<ServerChat.MessageInfo> messages = new ArrayList<>();
        try (Connection connection = ConnectionFactory.createConnection(config)) {
            Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
            Scan scan = new Scan();

            String startRow = toGroupID + "-";
            String stopRow = toGroupID + "-~";
            scan.withStartRow(Bytes.toBytes(startRow));
            scan.withStopRow(Bytes.toBytes(stopRow));

            ResultScanner scanner = table.getScanner(scan);
            for (Result result : scanner) {
                Integer msgID = Bytes.toInt(result.getValue(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("msgID")));
                Integer fromUserID = Bytes.toInt(result.getValue(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("fromUserID")));
                String messengerData = Bytes.toString(result.getValue(Bytes.toBytes(COLUMN_FAMILY), Bytes.toBytes("messengerData")));
                ServerChat.MessageInfo.Builder builder = ServerChat.MessageInfo.newBuilder();
                builder.setMsgID(msgID);
                builder.setFromUserID(fromUserID);
                builder.setToGroupID(toGroupID);
                builder.setMessengerData(messengerData);
                messages.add(builder.build());
            }
        }
        return messages;
    }
}