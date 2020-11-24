package cn.murphy.activemq.p2p;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsReceiver {

    public static void main(String[] args) throws JMSException {
        //connectionFactory 链接工厂 jms用它穿件链接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://127.0.0.1:61616"
                );

        //jms客户端到jms 生产者provider的链接
        Connection connect = connectionFactory.createConnection();
        connect.start();


        //session : 一个发送或接收消息的线程
        Session session = connect.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

        //destinaction//消息目的地，消息发送给谁
        //获取session注意参数值xingbo.xu-queue是一个服务器的queue 需要在activemq的console配资
        Destination destination = session.createQueue("my-queue");
        MessageConsumer consumer = session.createConsumer(destination);

        while (true){
            TextMessage message = (TextMessage) consumer.receive();
            if(null != message){
                System.out.println("收到消息"+message.getText());
                session.commit();
            }else{
                break;
            }
        }

        session.close();
        connect.close();




    }
}
