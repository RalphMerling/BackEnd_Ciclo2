## ANOTATIONS - ANOTAÇÕES
1. Anotações do Spring Web
`@RequestMapping("/medicos")`
=> Define que a classe está mapeada para a url[endpoint] /medicos.

`@RestController`
=> Define que a classe é uma classe controladora no Spring.

`@GetMapping` 
=> Define que o método será somente leitura.

`@PostMapping`
=> Define que o método irá receber dados.

`@PutMapping`
=> Atualiza alguma informação.

`@DeleteMapping`
=> Deleta dados.

`@ResquestBody`
=> é utilizada quando você irá receber dados pelo simulador de requisição [insomnia], e informa que os dados serão enviados no corpo da requisição.

`@Autowired`
=> é utilizado quando você está aplicando a injeção de depêndencia. Ou seja, o Springboot sabe o que a classe(interface) possui de métodos e atributos.

`@Transactional`
=> é utilizado para que o método consiga realizar algum tipo de modelagem(alteração) no BD.

## RELACIONAMENTO ENTRE TABELAS NO SPRINGBOOT
`@OneToOne` -> Um para um. (Uma consulta está ligada a um único médico).
`@OneToMany` -> Um para muitos. (Um médico tem várias consultas).
`@ManyToOne` -> Muitos para um. (Muitas consultas para um paciente).
`@ManyToMany` -> Muitos para Muitos. (Muitos pacientes para muitos médicos).

`Chave Primária (PK)` -> é o atributo(campo) que identifica a tabela(objeto) no BD.
`Chave Estrangeira (FK)` -> é o atributo PK que está mencionado em uma outra tabela, que por sua vez será uma chave estrangeira no BD.

OBS:
1. Sempre defina o lado "dono" da `relação(@JoinColumn)` o lado que tem a `FK(chave estrangeira).`


====================================================================ERROS==================================================================================

1=> No pom.xml está como spring-boot-starter-webmvc, mas tem que ser spring-boot-starter-web para rodar a aplicação

2=> No ProfessorController.java o método cadastrar está sem @Transactional. Dessa forma Spring não abre a transação com o BD e não consegue cadastrar um novo professor

3=> Em Aluno.java está @Table(name = "professores"), mas deve ser @Table(name = "alunos"), pois esse é o arquifo .java de alunos. Isso criaria um conflito com a entidade de professores

4=> Em DadosListagemAluno.java getNome() e getEmail() invertidos no construtor. A ordem em Aluno.java é nome depois email.

5=> Em AlunoController.java, como é uma atualização, deve ser @PutMapping , e não @PostMapping

6=> Em Professor.java está this.nome = dados.email(), sobrescrevendo o nome com o email. Deve ser this.email = dados.email() 

7=> Em MatriculaController.java está @PathVariable Integer ids o que não corresponde ao parâmetro {id} da URL. Trocar para id

8=> Em AlunoRepository.java precisa receber Integer ao invés de String

9=> Em MatriculaController.java o getReferenceById está com toString, mas o repositório espera um Integer. Retirei

10=> Em AlunoController.java precisa receber Integer ao invés de String