package model;

public class Path {
    private static final String BASEPATHLOGINUSER = "/api/auth/login";
    private static final String BASEPATHUSER = "/api/auth/user";
    private static final String BASEPATHCREATEUSER = "/api/auth/register";

    public String getBasePathLoginUser() {
        return BASEPATHLOGINUSER;
    }

    public String getBasePathUser() {
        return BASEPATHUSER;
    }

    public String getBasePathCreateUser() {
        return BASEPATHCREATEUSER;
    }
}