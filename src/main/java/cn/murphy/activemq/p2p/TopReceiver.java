package cn.murphy.activemq.p2p;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class TopReceiver {

   static  Logger log = LoggerFactory.getLogger(TopReceiver.class);


    private  static String BROKERURL = "tcp://127.0.0.1:61616";
    private static String TOPIC = "my-topic";


    public static void main(String[] args) throws JMSException {
        start();
    }

    public static  void  start() throws JMSException {
        log.info("消费者启动....");

        //创建会话工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new
                ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_USER,
                BROKERURL
        );

        Connection connection = activeMQConnectionFactory.createConnection();
        //启动jms连接
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC);

        MessageConsumer consumer = session.createConsumer(topic);

        while(true){
            TextMessage textMessage = (TextMessage) consumer.receive();
            if(null != textMessage){
                System.out.println("接受到消息:"+textMessage.getText());
            }else{
                break;
            }
        }
        connection.close();










    }



}
