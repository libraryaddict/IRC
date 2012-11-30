package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jibble.pircbot.DccFileTransfer;

public class IrcIncomingFileTransferEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String botName;
  private DccFileTransfer fileName;
  
  public IrcIncomingFileTransferEvent(DccFileTransfer file, String bName) {
    fileName = file;
    botName = bName;
  }
  
  public String getBot() {
    return botName;
  }
  
  public DccFileTransfer getDccFileTransfer() {
    return fileName;
  }

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
