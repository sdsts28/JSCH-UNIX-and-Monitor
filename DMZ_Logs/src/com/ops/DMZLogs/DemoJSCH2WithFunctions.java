package com.ops.DMZLogs;

import java.awt.Color;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class DemoJSCH2WithFunctions {
	
	private String user;
	private String password;
	private String hostname;
	private String port;
	private String command;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	
	public DemoJSCH2WithFunctions(String user, String password, String hostname, String port, String command) {
		super();
		this.user = user;
		this.password = password;
		this.hostname = hostname;
		this.port = port;
		this.command = command;
	}

	public DemoJSCH2WithFunctions() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws JSchException, InterruptedException, IOException {
		
	/*	Scanner in = new Scanner(System.in);
		user = in.nextLine();
		password = in.nextLine();
		hostname = in.nextLine();
		port = in.nextLine();
		command = in.nextLine();
		*/
		
		
		DemoJSCH2WithFunctions demoJSCH2WithFunctions = new DemoJSCH2WithFunctions();
		demoJSCH2WithFunctions.getData();
		demoJSCH2WithFunctions.RunCommand(demoJSCH2WithFunctions.getUser(), demoJSCH2WithFunctions.getHostname(), demoJSCH2WithFunctions.getPassword(), demoJSCH2WithFunctions.getPort(), demoJSCH2WithFunctions.getCommand());
		
		
		
		
	}
	
	private void getData() {
		   
		this.setUser(JOptionPane.showInputDialog("InputUserName"));
		this.setHostname(JOptionPane.showInputDialog("Input hostname"));
		this.setPassword(JOptionPane.showInputDialog("Input paswword"));
		this.setPort(JOptionPane.showInputDialog("Input port"));
		this.setCommand(ReturnCommand(this.getHostname(), this.getPort()));
		
		
	}
	
	private String ReturnCommand(String hostname, String port) {
		
		
		//if ladder node 1 QA
		if (hostname.equals("vdcaglq113.ics.cloud.ge.com"))
		{
			if (port.equals("9166"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9195/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9193"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9161/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9711"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9711/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9191"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9171/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9213"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9211/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9185"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9811/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9187"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9217/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9197") || port.equals("9176"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9176/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9156"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9156/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("1066"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/1066/IntegrationServer/instances/default/logs/server.log";
			}
		}
		if(hostname.equals("vdcaglq111.ics.cloud.ge.com"))
		{
			if(port.equals("8505"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/101BPMS/IntegrationServer/instances/default/logs/server.log";
			}
		}
		
		
		
		
		
		
		
		if (hostname.equals("avnls0426v01.ae.ge.com"))
		{
			if (port.equals("9166") || port.equals("9195"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9195/IntegrationServer/instances/default/logs/server.log";
			}
			
			
			//will uncomment on deploying on cluster
			/*if (port.equals("9193"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9161/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9711"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9711/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9191"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9171/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9213"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9211/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9185"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9811/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9187"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9217/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9197") || port.equals("9176"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9176/IntegrationServer/instances/default/logs/server.log";
			}
			if (port.equals("9156"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/9156/IntegrationServer/instances/default/logs/server.log";
			}*/
			if (port.equals("1066"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/IntegrationServers101/1066/IntegrationServer/instances/default/logs/server.log";
			}
		}
		
		if(hostname.equals("avnlt0426v01.ae.ge.com"))
		{
			if(port.equals("8505"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmEAI/app/101BPMS/IntegrationServer/instances/default/logs/server.log";
			}
		}
		
		
		
		//QA DMZ
		if(hostname.equals("avnls0502v01.ae.ge.com"))
		{
			if(port.equals("9706"))
			{
				return "sudo -u avwmeai -i cat /apps/AvWmB2B/New/IntegrationServers/9706/IntegrationServer/instances/default/logs/server.log";
			}
		}
		
		return "echo 'invalid input!!!....'";
	}
	private void RunCommand(String user, String hostname, String password, String port, String command) throws IOException, JSchException {
		//jsch 
				JSch jSch = new JSch();
				Session session= jSch.getSession(user, hostname, 22);
				//Session session= jSch.getSession("lg717630", "vdcaglq113.ics.cloud.ge.com", 22);
				session.setPassword(password);
				Properties properties = new Properties();
				properties.put("StrictHostKeyChecking", "no");
				session.setConfig(properties);
				session.connect();
				
				ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
				
				channelExec.setPty(true);
				channelExec.setCommand(command);

				//channelExec.setCommand("pwd");
				channelExec.connect();
				InputStream inputStream = channelExec.getInputStream();
				channelExec.setErrStream(System.err);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				
				String line;
				String lineCat = null;
				while ( (line = bufferedReader.readLine()) != null) {
					System.out.println(line);
					line+="\n";
					lineCat=lineCat+line;
				}
				
				channelExec.disconnect();
				session.disconnect();
				
				ShowOutput(lineCat);
				
				
	}
	
	
	private void ShowOutput(String lineCat)
	{
		JFrame jFrame = new JFrame("DMZ Logs Stage");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(100,100,1000,500);
		Container container = jFrame.getContentPane();
		
		JScrollPane jScrollPane = new JScrollPane();
		container.add(jScrollPane);
		
	
		
		JTextArea jTextArea = new JTextArea();
		jScrollPane.setViewportView(jTextArea);
		jTextArea.setBackground(Color.BLACK);
		jTextArea.setForeground(Color.GREEN);
		jTextArea.setText(lineCat);
		jFrame.setVisible(true);
	}
	
}
