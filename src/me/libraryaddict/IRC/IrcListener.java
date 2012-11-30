package me.libraryaddict.IRC;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.jibble.pircbot.DccChat;
import org.jibble.pircbot.DccFileTransfer;
import org.jibble.pircbot.PircBot;

class IrcListener extends PircBot {

	String[] MC = new String[22];
	String[] IRC = new String[22];
	Logger log = Logger.getLogger("Minecraft");
	private IrcListener inst = null;
	private String botName = null;
	private static IrcListener instance = null;
	private static Map<String, IrcListener> botNames = new HashMap<String, IrcListener>();

	protected IrcListener() {
	}

	public static IrcListener getInstance() {
		if (instance == null) {
			instance = new IrcListener();
		}
		return instance;
	}

	public IrcListener callBot(String name) {
		if (!botNames.containsKey(name)) { // Make instance and entry
			inst = new IrcListener();
			botNames.put(name, inst);
			inst.botName = name;
			return inst;
		}
		return botNames.get(name);
	}

	protected void onMessage(String channel, String sender, String login,
			String hostname, String message) {
		final IrcMessageEvent messageEvent = new IrcMessageEvent(sender,
				message, channel, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onNotice(String sourceNick, String sourceLogin,
			String sourceHostname, String target, String notice) {
		final IrcNoticeEvent messageEvent = new IrcNoticeEvent(sourceNick,
				target, notice, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onQuit(String sourceNick, String sourceLogin,
			String sourceHostname, String reason) {
		final IrcQuitEvent messageEvent = new IrcQuitEvent(sourceNick, reason,
				botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onKick(String channel, String kickerNick,
			String kickerLogin, String kickerHostname, String recipientNick,
			String reason) {
		final IrcKickEvent messageEvent = new IrcKickEvent(recipientNick,
				kickerNick, reason, channel, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onNickChange(String oldNick, String login, String hostname,
			String newNick) {
		final IrcNickChangeEvent messageEvent = new IrcNickChangeEvent(newNick,
				oldNick, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onAction(String sender, String login, String hostname,
			String target, String action) {
		final IrcActionEvent messageEvent = new IrcActionEvent(sender, target,
				action, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onPrivateMessage(String sender, String login,
			String hostname, String message) {
		IrcPrivateMessageEvent messageEvent = new IrcPrivateMessageEvent(
				sender, message, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onJoin(String channel, String sender, String login,
			String hostname) {
		IrcJoinEvent messageEvent = new IrcJoinEvent(sender, channel, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onInvite(String targetNick, String sourceNick,
			String sourceLogin, String sourceHostname, String channel) {
		IrcInviteEvent messageEvent = new IrcInviteEvent(sourceNick, channel,
				botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onDisconnect() {
		IrcOnDisconnectEvent messageEvent = new IrcOnDisconnectEvent(botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onConnect() {
		IrcOnConnectEvent messageEvent = new IrcOnConnectEvent(botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onChannelInfo(String channel, int userCount, String topic) {
		IrcChannelInfoEvent messageEvent = new IrcChannelInfoEvent(channel,
				userCount, topic, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onFileTransferFinished(DccFileTransfer transfer, Exception e) {
		IrcFileTransferFinishedEvent messageEvent = new IrcFileTransferFinishedEvent(
				transfer, e, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onIncomingChatRequest(DccChat chat) {
		IrcIncomingChatRequestEvent messageEvent = new IrcIncomingChatRequestEvent(
				chat, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}

	protected void onIncomingFileTransfer(DccFileTransfer transfer) {
		IrcIncomingFileTransferEvent messageEvent = new IrcIncomingFileTransferEvent(
				transfer, botName);
		Bukkit.getServer().getPluginManager().callEvent(messageEvent);
	}
}
