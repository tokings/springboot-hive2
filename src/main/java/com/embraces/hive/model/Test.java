package com.embraces.hive.model;

/**
 * hive表映射实体 <br>
 * 建表语句： <br>
 * CREATE EXTERNAL TABLE `test`( `a` int)<br> 
 * ROW FORMAT <br>
 * SERDE 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'<br> 
 * STORED AS <br>
 * INPUTFORMAT 'org.apache.hadoop.mapred.TextInputFormat'<br> 
 * OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'<br> 
 * LOCATION 'hdfs://master.embracesource.com:8020/user/root/examples/input-data/table'<br>
 * TBLPROPERTIES(<br>
 *  'last_modified_by'='root',<br> 
 *  'last_modified_time'='1516353365',<br>
 *  'numFiles'='1',<br>
 *  'totalSize'='31', <br>
 *  'transient_lastDdlTime'='1516353365'<br>
 * )<br>
 * 
 * @author tokings.tang@embracesource.com
 * @date 2018年3月15日 下午2:02:55
 * @copyright http://www.embracesource.com
 */
public class Test {

	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Test() {
	}

}
