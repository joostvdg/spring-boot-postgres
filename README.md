# spring-boot-postgres
Demo project for Spring Boot with Postgresql &amp; Service Bindings

## Docker Postgresql

```shell
docker run --name postgres -e POSTGRES_PASSWORD=admin -p 5432:5432 -d postgres
```
 

## Test Application

```shell
 http :8080
```

```shell
http POST :8080/create name=Andrea
```

## Create Workload

```shell
 tanzu apps workload create spring-boot-postgres-01 \                                                                                                                                                                              87%  
  --namespace default \
  --git-repo https://github.com/joostvdg/spring-boot-postgres.git \
  --git-branch main \
  --type web \
  --label app.kubernetes.io/part-of=spring-boot-mongo-01 \
  --annotation autoscaling.knative.dev/minScale=1 \
  --build-env BP_JVM_VERSION=17 \
  --service-ref db=services.apps.tanzu.vmware.com/v1alpha1:ResourceClaim:azure-mongodb-claim-01 \
  --yes
```