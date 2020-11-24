package cn.murphy.activemq.p2p;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 生产者
 */
public class Producter {

    public static void main(String[] args) throws JMSException {
        //connectionFactory 链接工厂，jms使用他创建链接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://127.0.0.1:61616"
        );

        //jms客户端到 jms 生产者provider的链接
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //session 一个发送或者接收消息的线程
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

        //Destination 消息的目的地，消息推送给谁
        //获取session注意参数值my-queue是query的名字
        Destination destination = session.createQueue("my-queue");

        //MessageProducer 消息生产者
        MessageProducer messageProducer = session.createProducer(destination);

        //设置是否持久化
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for(int i =1;i<=5;i++){
            sendMsg(session,messageProducer,i);

        }

        session.commit();
        connection.close();


    }

    public static void sendMsg(Session session,MessageProducer producer,int i) throws JMSException {
        //创建一条文本信息
        TextMessage message = session.createTextMessage("hello activeMq"+i);
        producer.send(message);
    }





}
