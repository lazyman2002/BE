package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.model.MessagesInfo;

import java.io.IOException;

public class HbaseService {

    private static final String TABLE_NAME = "Messengers";
    private static final String COLUMN_FAMILY = "info";

    private Connection connection;

    public HbaseService() throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "localhost");
        config.set("hbase.zookeeper.property.clientPort", "2181");
        config.set("hbase.master", "localhost:60000");

        this.connection = ConnectionFactory.createConnection(config);
        createTableIfNotExists();
    }

    private void createTableIfNotExists() throws IOException {
        Admin admin = connection.getAdmin();
        TableName table = TableName.valueOf(TABLE_NAME);

        if (!admin.tableExists(table)) {
            TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(table)
                    .setColumnFamily(ColumnFamilyDescriptorBuilder.of(COLUMN_FAMILY))
                    .build();
            admin.createTable(tableDescriptor);
        }

        admin.close();
    }
}
