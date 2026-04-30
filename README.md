# AI Commerce Enterprise

> Plataforma enterprise moderna baseada em **Microsserviços + Event-Driven + IA Corporativa**, construída com **Java + Spring Boot + Apache Kafka + Clean Architecture + RAG + MCP**.

Projeto desenhado para representar **arquitetura real de mercado**, pronto para evolução em ambientes corporativos, implementações técnicas de a nível de estudos para Engineer**, portfólio GitHub e estudo avançado de sistemas distribuídos.


Autor: Do ponto vista como desenvolvedor definir uma arquitetura de microservices, quase sempre uma tarefa complexa,
não fácil, visto que lidar com a complexidade e o grande volume de dados é as vezes caótico, e criar soluções
orientadas a eventos as vezes pode nos guiar a ganhos significativos.  
Pensando nisso desenvolvi uma pequena plataforma enterprise orientada a eventos com microsserviços Java + Spring Boot + Kafka.
Estruturei cada serviço em Clean Architecture.
Implementei um Agent Service com RAG para conhecimento corporativo e MCP para execução de ferramentas internas. Este
projeto foi criado para estudo avançado de arquitetura moderna e IA aplicada a sistemas corporativos.

---

# Sumário

- Visão Geral
- Objetivos do Projeto
- Arquitetura Geral
- Stack Tecnológica
- Conceitos Arquiteturais
- Estrutura do Monorepo
- Microsserviços
- Clean Architecture
- Fluxos de Negócio
- IA Corporativa (RAG + MCP)
- Event-Driven com Kafka
- Infraestrutura Local
- Como Executar
- Endpoints Iniciais
- Roadmap Evolutivo
- Segurança
- Observabilidade
- CI/CD
- Como Defender em Entrevista
- Próximos Passos

---

# Visão Geral

O **AI Commerce Enterprise** simula uma plataforma de e-commerce corporativa moderna com:

✅ Catálogo de produtos  
✅ Controle de estoque em tempo real  
✅ Gestão de pedidos  
✅ Pagamentos  
✅ Notificações  
✅ Agente de IA corporativo  
✅ Busca contextual inteligente (RAG)  
✅ Automações via ferramentas (MCP)  
✅ Comunicação assíncrona via Kafka  
✅ Arquitetura desacoplada e escalável

---

# Objetivos do Projeto

Este projeto foi criado para demonstrar domínio em:

- Arquitetura de Microsserviços
- Sistemas Orientados a Eventos
- Clean Architecture
- Java moderno (21+)
- Spring Boot 3+
- Kafka Production Ready
- Integração IA em sistemas corporativos
- Docker / Kubernetes Ready
- Design enterprise real

---

# Arquitetura Geral

```text
                        ┌──────────────────────┐
                        │   Frontend / App     │
                        └──────────┬───────────┘
                                   │
                        ┌──────────▼───────────┐
                        │     API Gateway      │
                        └──────────┬───────────┘
                                   │
                     ┌─────────────▼─────────────┐
                     │     agent-service (IA)    │
                     │   RAG + MCP + LLM Core    │
                     └─────────────┬─────────────┘
                                   │
──────────────────────────────────────────────────────────
                   Core Business Services
──────────────────────────────────────────────────────────
 product-service
 inventory-service
 order-service
 payment-service
 notification-service
 rag-indexer-service
──────────────────────────────────────────────────────────
                                   │
                           Apache Kafka
                                   │
──────────────────────────────────────────────────────────
 PostgreSQL | MongoDB | Redis | Vector DB
──────────────────────────────────────────────────────────

```

## Stack Tecnológica
Backend
Java 21
Spring Boot 3
Spring Web
Spring Data JPA
Spring Kafka
Spring Security
Bancos
PostgreSQL
MongoDB
Redis
pgvector
Event Streaming
Apache Kafka
IA
OpenAI / Local LLM
RAG
MCP
Infraestrutura
Docker
Docker Compose
Kubernetes (roadmap)
DevOps
GitHub Actions
Testcontainers
Prometheus
Grafana
Conceitos Arquiteturais
Microsserviços


## Cada domínio possui autonomia:

Banco isolado
Deploy independente
Escalabilidade separada
Responsabilidade única
Clean Architecture

## Separação rígida entre:

domain
application
infrastructure
adapters

## Benefícios:

Baixo acoplamento
Testabilidade alta
Regra de negócio independente de framework
Evolução sustentável
Event-Driven

## Integrações assíncronas usando Kafka:

order-created
payment-approved
stock-reserved
product-updated
notification-requested
IA Corporativa
RAG

Busca conhecimento corporativo em tempo real.

MCP

## Permite que a IA execute ferramentas internas:

consultar estoque
gerar relatório
enviar e-mail
consultar pedidos
criar refund


## Estrutura do Monorepo

```text
ai-commerce-enterprise/
│
├── pom.xml
├── docker-compose.yml
├── README.md
│
├── infra/
│   ├── kafka/
│   ├── postgres/
│   ├── mongodb/
│   └── redis/
│
├── common/
│   └── shared-kernel/
│
├── services/
│   ├── product-service/
│   ├── inventory-service/
│   ├── order-service/
│   ├── payment-service/
│   ├── notification-service/
│   ├── agent-service/
│   └── rag-indexer-service/

Estrutura Interna de Cada Serviço

product-service/
└── src/main/java/com/aicommerce/product
    ├── domain/
    │   ├── model/
    │   └── repository/
    │
    ├── application/
    │   ├── usecase/
    │   └── dto/
    │
    ├── infrastructure/
    │   ├── persistence/
    │   ├── kafka/
    │   └── config/
    │
    ├── adapters/
    │   └── controller/
    │
    └── ProductApplication.java
```

Microsserviços
product-service

Responsável por:

Cadastro de produtos
Alteração de preço
Categorias
Catálogo

Publica eventos:

product-created
product-updated
inventory-service

Responsável por:

Estoque disponível
Reserva
Baixa automática

Consome:

product-created
order-created
order-service

Responsável por:

Criação de pedidos
Status
Orquestração da compra

Publica:

order-created
payment-service

Responsável por:

Aprovação de pagamento
Refund
Antifraude inicial

Publica:

payment-approved
payment-failed
refund-created
notification-service

Responsável por:

E-mail
SMS
WhatsApp
Push

Consome eventos de negócio.

agent-service

Coração de IA do sistema.

Responsável por:

Interpretar perguntas
Escolher tool MCP
Buscar contexto RAG
Responder usuário
Executar automações
rag-indexer-service

Responsável por:

Processar documentos
Gerar embeddings
Atualizar base vetorial
Indexar catálogo
Fluxos de Negócio
Compra

```text
POST /orders
↓
order-created
↓
inventory reserves stock
↓
payment approves
↓
payment-approved
↓
notification sends email
Pergunta IA

```

Usuário:

Posso vender 200 notebooks amanhã?

Fluxo:

```text
agent-service
↓
MCP consulta estoque
↓
RAG busca política mínima
↓
Kafka verifica reservas
↓
IA responde
RAG (Retrieval-Augmented Generation)

```

Base documental:

FAQ
Política de troca
Política de estoque
Catálogo textual
Playbooks internos

Pipeline:

```text
Documento
↓
Chunking
↓
Embeddings
↓
pgvector
↓
Similarity Search
↓
LLM
MCP (Model Context Protocol)

```

Ferramentas disponíveis:

get_stock(sku)
generate_report(month)
send_email(to)
create_refund(orderId)
customer_history(id)
top_sales()
Infraestrutura Local
docker-compose.yml

Serviços locais:

PostgreSQL
MongoDB
Redis
Kafka
Zookeeper
Microsserviços
Como Executar
Pré-requisitos
Docker
Docker Compose
Java 21
Maven 3.9+
Rodar tudo
docker compose up --build

Rodar individual
mvn clean install
mvn spring-boot:run

Endpoints Iniciais
Produto
POST /products
GET /products
Estoque
GET /inventory/{sku}
Pedido
POST /orders
Agent IA
POST /agent/ask

Body:
```
{
  "question": "Qual estoque do NB001?"
}
```

Segurança

## Roadmap:

JWT
OAuth2
RBAC
Audit logs
Tool Allowlist
Prompt Injection Defense
Observabilidade

## Roadmap:

Spring Actuator
Prometheus
Grafana
OpenTelemetry
Distributed Tracing
CI/CD

## GitHub Actions:

Build Maven
Testes
SonarQube
Docker Build
Deploy Kubernetes
Roadmap Evolutivo

## Fase 1
product-service
inventory-service
Kafka
Docker

## Fase 2
order-service
payment-service
saga

## Fase 3
agent-service
MCP tools
Fase 4
RAG real com pgvector

## Fase 5
Kubernetes
Observabilidade
CI/CD

Diferenciais Reais

✅ Projeto fora do padrão CRUD comum
✅ Forte aderência ao mercado 2026
✅ Excelente para entrevistas senior
✅ Excelente para GitHub público
✅ Demonstra visão de Staff Engineer

Próximos Passos
Implementar JWT
Testcontainers
Swagger
Kubernetes
Terraform
OpenAI Integration
Multi-agent orchestration

