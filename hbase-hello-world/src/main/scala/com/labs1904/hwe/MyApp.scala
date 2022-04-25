package com.labs1904.hwe

import com.labs1904.hwe.MyApp.logger
import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, Delete, Get, Put, Result, Row, Scan}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.logging.log4j.{LogManager, Logger}

import scala.collection.JavaConverters.{asJavaIterableConverter, asScalaIteratorConverter}
import scala.collection.convert.ImplicitConversions.`iterator asScala`

object MyApp {
  lazy val logger: Logger = LogManager.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    logger.info("MyApp starting...")
    var connection: Connection = null
    try {
      val conf = HBaseConfiguration.create()
      conf.set("hbase.zookeeper.quorum", "CHANGE ME")
      connection = ConnectionFactory.createConnection(conf)
      // Example code... change me
      val table = connection.getTable(TableName.valueOf("kgruenewald:users"))


//      val get = new Get(Bytes.toBytes("10000001"))
//      get.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("mail")) // specifies only return this column
//      val result = table.get(get)
//      val message = Bytes.toString(result.getValue(Bytes.toBytes("f1"), Bytes.toBytes("mail"))) // show me just this column
//      logger.debug(message) // dmeadows@yahoo.com

//      val put = new Put(Bytes.toBytes("99"))
//      put.addColumn(
//        Bytes.toBytes("f1"),
//        Bytes.toBytes("username"),
//        Bytes.toBytes("DE_HWE")
//      )
//      put.addColumn(
//        Bytes.toBytes("f1"),
//        Bytes.toBytes("name"),
//        Bytes.toBytes("The Panther")
//      )
//      put.addColumn(
//        Bytes.toBytes("f1"),
//        Bytes.toBytes("sex"),
//        Bytes.toBytes("F")
//      )
//      put.addColumn(
//        Bytes.toBytes("f1"),
//        Bytes.toBytes("favorite_color"),
//        Bytes.toBytes("pink")
//      )
//      val putResult = table.put(put)
//      logger.debug(putResult)

      //val get = new Get(Bytes.toBytes("99"))
      //get.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("name")) // specifies only return this column
//      val result = table.get(get)
//      val message = Bytes.toString(result.getRow()) // show me just this column
//      logger.debug(message)

      // execute scan, get result, count how many
      // val scan = new Scan().withStartRow(Bytes.toBytes("10000001")).withStopRow(Bytes.toBytes("10006001"))
      // val scanner = table.getScanner(scan)
      // val test = scanner.iterator().asScala
      // println(test.size) //461
      //logger.debug(test.size)

//      val myDeleteObject = new Delete(Bytes.toBytes("99"))
//      table.delete(myDeleteObject)

      val get = new Get(Bytes.toBytes("9005729")).addColumn(Bytes.toBytes("f1"), Bytes.toBytes("email"))
      val get2 = new Get(Bytes.toBytes("500600")).addColumn(Bytes.toBytes("f1"), Bytes.toBytes("email"))
      val get3 = new Get(Bytes.toBytes("30059640")).addColumn(Bytes.toBytes("f1"), Bytes.toBytes("email"))
      val get4 = new Get(Bytes.toBytes("6005263")).addColumn(Bytes.toBytes("f1"), Bytes.toBytes("email"))
      val get5 = new Get(Bytes.toBytes("800182")).addColumn(Bytes.toBytes("f1"), Bytes.toBytes("email"))
      val getList = List(get, get2, get3, get4, get5)
      val results = Array(5)
      //val result = table.batch(getList, results)
      //logger.debug(result)




    } catch {
      case e: Exception => logger.error("Error in main", e)
    } finally {
      if (connection != null) connection.close()
    }
  }
}
