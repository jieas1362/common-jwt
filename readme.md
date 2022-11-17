# jwt token

### application.yml
```
jwt:
  globalMaxExpiresMillis: ******
  globalMinExpiresMillis: ******
  globalRefreshExpiresMillis: ******
  signKey: ******
  gammaSecrets: [ ******, ******, ......]
```




### project
#### config class
```
@Component
@ConfigurationProperties(prefix = "jwt")
public class ProUserJwtConfig extends UserJwtConfParams {
}
```

#### use
```
    @Autowired
    private JwtProcessor<T> jwtProcessor;

    jwtProcessor.create(t);
    jwtProcessor.parse(jwt);
```