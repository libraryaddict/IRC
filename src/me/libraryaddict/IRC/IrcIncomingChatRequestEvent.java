package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jibble.pircbot.DccChat;

public class IrcIncomingChatRequestEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String botName;
  DccChat chat;
  
  public IrcIncomingChatRequestEvent(DccChat cha, String bName) {
    chat = cha;
    botName = bName;
  }
  
  public String getBot() {
    return botName;
  }
  
  public DccChat getDccChat() {
    return chat;
  }

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
