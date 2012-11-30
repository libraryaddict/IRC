package me.libraryaddict.IRC;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.logging.Logger;

import org.jibble.pircbot.DccChat;
import org.jibble.pircbot.DccFileTransfer;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.User;

public class IrcApi implements Interface {

	IrcListener plugin;
	Logger log = Logger.getLogger("Minecraft");

	public IrcApi(String botName) {
		plugin = IrcListener.getInstance().callBot(botName);
	}

	public IrcApi() {
		plugin = IrcListener.getInstance();
	}

	/*
	 * public IrcListener callBot(String botName) { return
	 * plugin.callBot(botName); }
	 */

	@Override
	public void connect(String hostname) throws IOException, IrcException,
			NickAlreadyInUseException {
		plugin.connect(hostname);
	}

	@Override
	public void connect(String hostname, int port) throws IOException,
			IrcException, NickAlreadyInUseException {
		plugin.connect(hostname, port);
	}

	@Override
	public void connect(String hostname, int port, String password)
			throws IOException, IrcException, NickAlreadyInUseException {
		plugin.connect(hostname, port, password);
	}

	@Override
	public void reconnect() throws IOException, IrcException,
			NickAlreadyInUseException {
		plugin.reconnect();
	}

	@Override
	public void disconnect() {
		plugin.disconnect();
	}

	@Override
	public void setAutoNickChange(boolean autoNickChange) {
		plugin.setAutoNickChange(autoNickChange);
	}

	@Override
	public void startIdentServer() {
		plugin.startIdentServer();
	}

	@Override
	public void joinChannel(String channel) {
		plugin.joinChannel(channel);
	}

	@Override
	public void joinChannel(String channel, String key) {
		plugin.joinChannel(channel, key);
	}

	@Override
	public void partChannel(String channel) {
		plugin.partChannel(channel);
	}

	@Override
	public void partChannel(String channel, String reason) {
		plugin.partChannel(channel, reason);
	}

	@Override
	public void quitServer() {
		plugin.quitServer();
	}

	@Override
	public void quitServer(String reason) {
		plugin.quitServer(reason);
	}

	@Override
	public void sendRawLine(String line) {
		plugin.sendRawLine(line);
	}

	@Override
	public void sendRawLineViaQueue(String line) {
		plugin.sendRawLineViaQueue(line);
	}

	@Override
	public void sendMessage(String target, String message) {
		 plugin.sendMessage(target, message);
	}

	@Override
	public void sendAction(String target, String action) {
		 plugin.sendAction(target, action);
	}

	@Override
	public void sendNotice(String target, String notice) {
		plugin.sendNotice(target, notice);
	}

	@Override
	public void sendCTCPCommand(String target, String command) {
		plugin.sendCTCPCommand(target, command);
	}

	@Override
	public void changeNick(String newNick) {
		plugin.changeNick(newNick);
	}

	@Override
	public void identify(String password) {
		plugin.identify(password);
	}

	@Override
	public void setMode(String channel, String mode) {
		plugin.setMode(channel, mode);
	}

	@Override
	public void sendInvite(String nick, String channel) {
		plugin.sendInvite(nick, channel);
	}

	@Override
	public void ban(String channel, String hostmask) {
		plugin.ban(channel, hostmask);
	}

	@Override
	public void unBan(String channel, String hostmask) {
		plugin.unBan(channel, hostmask);
	}

	@Override
	public String getPrefix(String channel, String nick) {
		return plugin.getPrefix(channel, nick);
	}

	@Override
	public void op(String channel, String nick) {
		plugin.op(channel, nick);
	}

	@Override
	public void deOp(String channel, String nick) {
		plugin.deOp(channel, nick);
	}

	@Override
	public void voice(String channel, String nick) {
		plugin.voice(channel, nick);
	}

	@Override
	public void deVoice(String channel, String nick) {
		plugin.deVoice(channel, nick);
	}

	@Override
	public void setTopic(String channel, String topic) {
		plugin.setTopic(channel, topic);
	}

	@Override
	public void kick(String channel, String nick) {
		plugin.kick(channel, nick);
	}

	@Override
	public void kick(String channel, String nick, String reason) {
		plugin.kick(channel, nick, reason);
	}

	@Override
	public void listChannels() {
		plugin.listChannels();
	}

	@Override
	public void listChannels(String parameters) {
		plugin.listChannels(parameters);
	}

	@Override
	public DccFileTransfer dccSendFile(File file, String nick, int timeout) {
		return plugin.dccSendFile(file, nick, timeout);
	}

	@Override
	public DccChat dccSendChatRequest(String nick, int timeout) {
		return plugin.dccSendChatRequest(nick, timeout);
	}

	@Override
	public void log(String line) {
		plugin.log(line);
	}

	@Override
	public void setVerbose(boolean verbose) {
		plugin.setVerbose(verbose);
	}

	@Override
	public void setName(String name) {
		plugin.setName(name);
	}

	@Override
	public String getName() {
		return plugin.getName();
	}

	@Override
	public String getNick() {
		return plugin.getNick();
	}

	@Override
	public String getLogin() {
		return plugin.getLogin();
	}

	@Override
	public String getVersion() {
		return plugin.getVersion();
	}

	@Override
	public String getFinger() {
		return plugin.getFinger();
	}

	@Override
	public boolean isConnected() {
		return plugin.isConnected();
	}

	@Override
	public void setMessageDelay(long delay) {
		plugin.setMessageDelay(delay);
	}

	@Override
	public long getMessageDelay() {
		return plugin.getMessageDelay();
	}

	@Override
	public int getMaxLineLength() {
		return plugin.getMaxLineLength();
	}

	@Override
	public int getOutgoingQueueSize() {
		return plugin.getOutgoingQueueSize();
	}

	@Override
	public String getServer() {
		return plugin.getServer();
	}

	@Override
	public int getPort() {
		return plugin.getPort();
	}

	@Override
	public String getPassword() {
		return plugin.getPassword();
	}

	@Override
	public int[] longToIp(long address) {
		return plugin.longToIp(address);
	}

	@Override
	public long ipToLong(byte[] address) {
		return plugin.ipToLong(address);
	}

	@Override
	public void setEncoding(String charset) throws UnsupportedEncodingException {
		plugin.setEncoding(charset);
	}

	@Override
	public String getEncoding() {
		return plugin.getEncoding();
	}

	@Override
	public InetAddress getInetAddress() {
		return plugin.getInetAddress();
	}

	@Override
	public void setDccInetAddress(InetAddress dccInetAddress) {
		plugin.setDccInetAddress(dccInetAddress);
	}

	@Override
	public InetAddress getDccInetAddress() {
		return plugin.getDccInetAddress();
	}

	@Override
	public int[] getDccPorts() {
		return plugin.getDccPorts();
	}

	@Override
	public void setDccPorts(int[] ports) {
		plugin.setDccPorts(ports);
	}

	@Override
	public User[] getUsers(String channel) {
		return plugin.getUsers(channel);
	}

	@Override
	public User getUser(String channel, String name) {
		return plugin.getUser(channel, name);
	}

	@Override
	public String[] getChannels() {
		return plugin.getChannels();
	}

	@Override
	public void dispose() {
		plugin.dispose();
	}

	@Override
	public void enableDelay() {
		plugin.enableDelay();
	}

	@Override
	public void disableDelay() {
		plugin.disableDelay();
	}

	@Override
	public boolean isDelay() {
		return plugin.isDelay();
	}

}
