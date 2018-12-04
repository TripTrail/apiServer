package com.company.application.constants;

public class Constant {

  public final static String COMPONENT_SCAN_PACKAGE = "com.company";
  public final static String MESSAGE_BASE_NAME = "classpath:messages";
  public final static String UTF8_ENCODING = "UTF-8";
  public final static String SUCCESS_MESSAGE = "success";
  public final static String AUDITOR_AWARE = "auditorAware";
  public final static String ADMIN_USER = "Admin";

  public final static String NULL = null;
  public final static String INTERNAL_SERVER_ERROR = "Something Went Wrong! Please try again later.";

  public final static String AUTH_MANAGER_BEAN = "authenticationManagerBean";
  public final static String DATASOURCE = "dataSource";
  public final static String SCHEMA_SCRIPT = "classpath:schema.sql";

  public final static String OAUTH_CLIENT_ID = "${security.oauth2.client.client-id}";
  public final static String OAUTH_CLIENT_SECRET = "${security.oauth2.client.client-secret}";
  public final static String OAUTH_CLIENT_GRANT_TYPES = "${security.oauth2.client.authorized-grant-types}";
  public final static String OAUTH_CLIENT_SCOPE = "${security.oauth2.client.scope}";
  public final static String OAUTH_CLIENT_ACCESS_TOKEN_VALIDITY = "${security.oauth2.client.access-token-validity-seconds}";
  public final static String OAUTH_CLIENT_REFRESH_TOKEN_VALIDITY = "${security.oauth2.client.refresh-token-validity-seconds}";

  public final static String OAUTH_TOKEN_URL = "/oauth/token";
  public final static String ALL_URL_PATTERN = "/**";
  public final static String ALL_PUBLIC_URL_PATTERN = "/api/public/**";
}
