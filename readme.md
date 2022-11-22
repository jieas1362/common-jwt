# jwt token

### application.yml
```
jwt:
  maxExpiresMillis: 7776000000
  minExpiresMillis: 259200000
  refreshExpiresMillis: 7776000000
  signKey: ******
  gammaSecrets: [ ******, ******, ......]
```




### project
#### config class
```
@Component
@ConfigurationProperties(prefix = "jwt")
public class ProJwtConfig extends BaseJwtConfParams<UserPayload> {


    @Override
    public Function<UserPayload, Map<String, String>> getDataToClaimProcessor() {
        return p -> {
            Map<String, String> claims = new HashMap<>(8, 2.0f);
            claims.put("t", p.getGamma());
            claims.put("h", p.getRedisId());
            claims.put("i", p.getId());
            claims.put("n", p.getCredentialType());
            claims.put("g", p.getDeviceType());
            claims.put("s", p.getLoginTime());
            return claims;
        };
    }

    @Override
    public Function<Map<String, String>, UserPayload> getClaimToDataProcessor() {
        return c -> {
            UserPayload userPayload = new UserPayload();
            userPayload.setCredentialType(c.get("n"));
            userPayload.setDeviceType(c.get("g"));
            userPayload.setGamma(c.get("t"));
            userPayload.setRedisId(c.get("h"));
            userPayload.setId(c.get("i"));
            userPayload.setLoginTime(c.get("s"));
            return userPayload;
        };
    }
}
```

#### user model
```
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public final class UserPayload extends BasePayload implements Serializable {

    private static final long serialVersionUID = 2135297516865116214L;


    /**
     * credential type
     */
    private String credentialType;

    /**
     * device type
     */
    private String deviceType;


    public UserPayload(String gamma, String redisId, String id, String credentialType, String deviceType, String loginTime) {
        this.setCredentialType(credentialType);
        this.setDeviceType(deviceType);
        this.setGamma(gamma);
        this.setRedisId(redisId);
        this.setId(id);
        this.setLoginTime(loginTime);
    }
}
```

#### use
```
    @Autowired
    private JwtProcessor<UserPayload> jwtProcessor;

    jwtProcessor.create(t);
    jwtProcessor.parse(jwt);
```