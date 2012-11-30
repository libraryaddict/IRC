package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jibble.pircbot.DccFileTransfer;

public class IrcFileTransferFinishedEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String botName;
  private DccFileTransfer transfer;
  private Exception ex;
  
  public IrcFileTransferFinishedEvent(DccFileTransfer trans, Exception e, String bName) {
    botName = bName;
    transfer = trans;
    ex = e;
  }
  
  public String getBot() {
    return botName;
  }
  
  public DccFileTransfer getTransfer() {
    return transfer;
  }
  
  public Exception getException() {
    return ex;
  }

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
