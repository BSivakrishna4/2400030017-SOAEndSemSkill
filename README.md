## About the Project

1. This project implements Round Robin Load Balancing using Spring Cloud Gateway.
2. Three Driver Service instances run on different ports.
3. Eureka Server registers and discovers all three service instances.
4. API Gateway distributes incoming GET requests among the available instances.
5. The output displays the instance ID and port, verifying Round Robin request distribution.