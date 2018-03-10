package com.advanced.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class TestAD {
	public static void main(String[] args) {
		
		String ldapURL = "ldap://0.0.0.0";
		String account = "";
		String password = "";
		try {
			LDAP_AUTH_AD(ldapURL, account, password);
			System.out.println("認證成功!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/******************************
	 * LDAP認證
	 * 
	 * @throws Exception
	 ******************************/
	public static void LDAP_AUTH_AD(String ldap_url, String account, String password) throws Exception {
		if (account.isEmpty() || password.isEmpty())
			throw new Exception("認證失敗!");

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		// 傳入AD Server位置
		env.put(Context.PROVIDER_URL, ldap_url);
		// 可以設定三種參數(none, simple, strong)
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		// 傳入帳號並冠上Domain
		env.put(Context.SECURITY_PRINCIPAL, "TAIPEI\\" + account);
		// 密碼
		env.put(Context.SECURITY_CREDENTIALS, password);

		LdapContext ctx = null;
		try {
			ctx = new InitialLdapContext(env, null);
		} catch (javax.naming.AuthenticationException e) {
			throw new Exception("認證失敗!");
		} catch (javax.naming.CommunicationException e) {
			throw new Exception("找不到伺服器!");
		} catch (Exception e) {
			throw new Exception("發生未知的錯誤!");
		} finally {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e) {
				}
			}
		}
	}
}
