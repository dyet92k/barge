package org.robotninjas.barge.jaxrs.ws;

import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.servlet.*;

import java.util.Collections;


/**
 */
public class EventServlet extends WebSocketServlet {
  private final WsEventListener events;

  public EventServlet(WsEventListener events) {
    this.events = events;
  }

  @Override
  public void configure(WebSocketServletFactory factory) {
    factory.setCreator((req, resp) -> {

      // remove all compressions extensions that might be requested by the browser...
      resp.setExtensions(Collections.<ExtensionConfig>emptyList());

      return new EventSocket(events);
    });
  }
}
