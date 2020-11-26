package cn.murphy.activemq.p2p;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class TopicSender {

    public static Logger log = LoggerFactory.getLogger(TopicSender.class);

    private static String BROKERURL = "tcp://127.0.0.1:61616";

    private static String TOPIC = "my-topic";


    public static void main(String[] args) throws JMSException {
        start();
    }


    public static void start() throws JMSException {
        log.info("生产者已经启动.......");
        //创建会话工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                        ActiveMQConnection.DEFAULT_PASSWORD,BROKERURL
                        );
        //启动jms连接
        Connection connection = activeMQConnectionFactory.createConnection();


        connection.start();

        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(null);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        send(producer,session);
        log.info("发送成功");
        connection.close();





    }

    private static void send(MessageProducer producer, Session session) throws JMSException {
        for(int i =1;i<=5;i++){
            log.info("我是消息"+i);
            TextMessage textMessage = session.createTextMessage("我是消息"+i);
            Destination destination = session.createTopic(TOPIC);
            producer.send(destination,textMessage);
        }


    }


}
