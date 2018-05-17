/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pensare.xmmp.chat;


import org.junit.Test;
import org.junit.Assert;
import rocks.xmpp.addr.Jid;
import rocks.xmpp.core.XmppException;
import rocks.xmpp.core.session.TcpConnectionConfiguration;
import rocks.xmpp.core.session.XmppClient;
import rocks.xmpp.core.stanza.model.Message;
import rocks.xmpp.core.stanza.model.Presence;
import rocks.xmpp.im.roster.RosterManager;

/**
 *
 * @author manuel
 */
public class ChatDriverTest {

    private XmppClient xmppClient;

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        TcpConnectionConfiguration tcpConfiguration = TcpConnectionConfiguration.builder()
                .hostname("192.168.1.111")
                .port(5222)
                .secure(false)
                .build();
        xmppClient = XmppClient.create("pensare.mx", tcpConfiguration);
        // Listen for presence changes
        xmppClient.addInboundPresenceListener(e -> {
            // Handle inbound presence.
        });
// Listen for messages
        xmppClient.addInboundMessageListener(e -> {
            // Handle inbound message
            System.out.println(e);
        });
// Listen for roster pushes
        xmppClient.getManager(RosterManager.class).addRosterListener(e -> {

        });

        try {
            xmppClient.connect();
            xmppClient.login("luis", "pass", "nuevoclient");
            xmppClient.send(new Presence(Presence.Show.CHAT));
            xmppClient.send(new Message(Jid.of("manuel@pensare.mx"), Message.Type.CHAT, "holis :v"));
        } catch (XmppException e) {
            System.out.println(e);
            Assert.assertTrue(false);
            // ...
        }
        Runnable myRunnable = () -> {
            System.out.println("Runnable running");
            while(true){}
        };

        Thread thread = new Thread(myRunnable);
        thread.start();
        while(true){
            
        }
    }

}
