# Api-Compras-On-line
## Api para um sistema de compras on-line

### Para testar e rodar a API, será necessário:   
 
 ### 1 - configurar o banco de dados na aplicação
 ### 2 - criar o banco de dados e suas tabelas (MySQL)
 
 #### Configurar application.properties                                                                                                                                                           
        // Caminho do banco de dados - Exemplo                                                                                                                                              
        spring.datasource.url=jdbc:mysql://localhost:3306/sistema_compras                                                                                                                                                                                                                                           
        // Usuário do banco de dados - Exemplo                                                                                                                                                
        spring.datasource.username=root                                                                                                                                                            
        // Senha do banco de dados - Exemplo                                                                                                                                                      
        spring.datasource.password=123                                                                                                                                                          
 #### Criar o banco de dados e suas tabelas (MySQL)                                                                                                                                          
   *todos os scripts para criação do banco e tabelas está no arquivo scripts.sql*      
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Neste sistema, o usuario administrador terá que ser autenticado para realizar o cadastro de produtos, categorias de produtos e descontos**                                                                                                                                                                                                                            Para isso é necessário utilizar a url de autenticação: localhost:8080/authenticate, informando "username" e "password" num formato json: como no exemplo a seguir
![Autenticar](https://i.imgur.com/7Tobvex.png)                                                                                                                                                                                                                                                                                                                          Após isso será retornado uma chave, essa chave será incluida no header da requisição:                                                                                                                                                                                                                                                   
 Key=Authorization                                                                                                                                                                
 Value= Bearer {chave}                                                                                                                                                            
 Exemplo:
 ![Autenticado](https://i.imgur.com/XOIPYRb.png)                                                                                                                                  
**Feito isso o adm terá permissão para utilizar os endpoints:**                                                                                                                      
  - localhost:8080/produtos  
  - localhost:8080/categorias  
  - localhost:8080/descontos      
                                                                                                                                                                                  
**No caso do cadatro de clientes, os endpoints de cadastro de clientes e inclusão de produtos no carrinho não é necessario autenticação.**                                         
 - localhost:8080/clientes 
 - localhost:8080/clientes/carrinho
