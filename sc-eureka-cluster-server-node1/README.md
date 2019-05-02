https://blog.csdn.net/huanxianglove/article/details/80690130

Eureka Client配置:
eureka:
  client:
    service-url:
      default-zone: http://discovery1:8761/eureka/,http://discovery2:8762/eureka/,http://discovery3:8763/eureka/
#  instance:
#    hostname: discover
spring:
  application:
    name: client
server:
  port: 80