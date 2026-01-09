```
(\ (\
( • •)  
━∪∪━━━━ 
ᵇʸ ᴬˡᵉᶠᵘᵉⁿᵗᵉˢ
```
# fintech-lending-ecosystem
<img src="https://img.shields.io/badge/Java_v21-informational?style=flat-square&logo=openjdk&logoColor=000000&color=ffffff" /> <img src="https://img.shields.io/badge/Spring_Boot_v3.5-informational?style=flat-square&logo=spring&logoColor=6db33f&color=ffffff" /> <img src="https://img.shields.io/badge/Maven-informational?style=flat-square&logo=apachemaven&logoColor=c71a36&color=ffffff" /> <img src="https://img.shields.io/badge/Angular_v20-informational?style=flat-square&logo=angular&logoColor=0F0F11&color=ffffff" /> <img src="https://img.shields.io/badge/Tailwind_CSS_v3.4-informational?style=flat-square&logo=tailwindcss&logoColor=06B6D4&color=ffffff" /> 𖥔 <img src="https://img.shields.io/badge/Docker-informational?style=flat-square&logo=docker&logoColor=2496ed&color=ffffff" /> <img src="https://img.shields.io/badge/CI/CD_GitHub_Actions-informational?style=flat-square&logo=githubactions&logoColor=2088FF&color=ffffff" /> 

> Enterprise-grade microservices ecosystem for credit assessment. Built with Java 21, Spring Boot 3.4, and Angular 20. Implementing Hexagonal Architecture, DDD, and SOLID principles. Features real-time synchronous communication via WebClient, SQL Server persistence, and automated CI/CD pipelines with GitHub Actions.



# Troubleshooting

## Docker

### Verificar SQL Server

Utilizando powershell

```bash
docker exec -it fintech-db find /opt -name "sqlcmd"
# saida
/opt/mssql-tools18/bin/sqlcmd
```


```bash
docker exec -it fintech-db /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P 'rooT123!' -C -d master -Q "SELECT * FROM clients;"
```

> ☕︎ ˖ NOTA : to insert a record
>
>    ```bash
>    docker exec -it fintech-db /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P 'rooT123!' -C -d master -Q "INSERT INTO clients (dni, full_name, income) VALUES ('12345', 'Alejandro Fuentes', 5000.00);"
>    ```
 
 


