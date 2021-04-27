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

** Neste sistema, o usuario administrador terá que ser autenticado para realizar o cadastro de produtos, categorias de produtos e descontos **                                                                                                                                                                                                                            Para isso é necessário utilizar a url de autenticação: localhost:8080/authenticate     
