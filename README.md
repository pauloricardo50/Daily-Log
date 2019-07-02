# _Daily Log 1.1.0_

<P align="justify">&nbsp&nbsp Continuação do projeto Daily Log, que surgio por meio da disciplina de Programação Orientada a Objetos do curso Bacharelado em Sistemas de Informação (IFES - Campus Serra) no semestre 2018/2. Nessa nova versão do projeto iremos implementar padrões de projeto e também analisar o sistema do ponto de vista de projeto de sistema.</p>


### 1. COMPONENTES<br>
**Integrantes do grupo:**<br>
-  Jardielma Queiroz de Lima:<a href="url"> jardielmaqueiroz@hotmail.com </a>
-  Paulo Ricardo Viana Ferreira:<a href="url"> paulo_ricardosf@outlook.com <br></a>

### 2. JUSTIFICATIVA DO SISTEMA<br>
<P align="justify">&nbsp&nbsp O sistema tem como propósito principal fazer o controle do tempo gasto com realização de atividades durante o expediente de trabalho. Além disso, o mesmo será utilizado como mediador para tomada de decisões estratégicas referentes à organização de atividades no trabalho, uma vez que essa ferramenta terá a capacidade de medir o tempo que está sendo gasto com cada atividade.</p>

### 3.MINI-MUNDO<br>
<P align="justify">&nbsp&nbsp A principal funcionalidade do sistema é controlar as atividades que os gestores desenvolvem no decorrer do expediente de trabalho, ações necessárias ou eventos significativos que não foram capturados no dia-a-dia e mostrar para eles dados estatísticos sobre as categorias de atividades que estão demandando maior parte do seu tempo. Categoria de atividade é uma classificação para identificar as características da atividade, já as subcategorias são as especificidades de cada categoria de atividade. Uma atividade possui titulo, descrição, duração, categoria, subcategoria, data e horário em que foi iniciada e concluída. As atividades devem ser iniciadas e finalizadas durante o horário de início e fim do expediente. Uma Atividade é formada por participações, que são os intervalos de tempo que foi dedicado para aquela atividade, juntamente com o  que foi realizado. Além disso, deve ser permitido que outras pessoas participem da atividade, ou seja, possam adicionar participações na atividade que selecionar. O responsável pela atividade deverá ser informado quando outra pessoa adicionar uma participação. Após isso, ele poderá confirmar ou cancelar a participação quando a mesma for inserida por outra pessoa.</p>
 
<P align="justify">&nbsp&nbsp Caso uma participação na atividade seja iniciada e não seja concluída até o horário de fim do expediente a mesma será considerada como concluída. Vários usuários podem participar de uma atividade, no entanto cada usuário fica responsável pela sua participação na atividade.</p>
 
<P align="justify">&nbsp&nbsp Após uma atividade ser inserida no sistema, ela só poderá ser editada e ou deletada durante o período (30 dias) que estiver apta a receber modificações, após esse período nenhuma alteração será permitida. Duas atividades não podem ser inseridas no mesmo horário, caso aconteça, o sistema deve alertar que já existe uma atividade agendada para fazer naquele horário, não permitindo sobrescreve-lá a menos que a pessoa confirme que deseja descartar a atividade existente e permanecer com a nova. Além disso, o sistema deve permitir que o horário do expediente de trabalho - ex: 08h às 18h ou 12h às 19h seja definido, podendo posteriormente editar o horário do expediente de acordo com a necessidade. Além de, poder inserir, atualizar, deletar e consultar atividades que realizou. Apenas as pessoas que possuírem perfil de usuário comum ou de administrador do sistema poderão executar as funcionalidades citadas acima. Perfil de usuário será uma forma de atribuir responsabilidades às pessoas que utilizarão o sistema, de modo que para cada perfil será atribuído funcionalidades específicas.</p>
 
<P align="justify">&nbsp&nbsp Deverá ser permitido, que pessoas com perfis autorizados (Usuário Administrador e usuário de cadastro), cadastrem novas categorias e subcategorias, destacando que só é possível criar subcategoria para uma categoria já existente e uma subcategoria está vinculada apenas a uma categoria.</p>
 
<P align="justify">&nbsp&nbsp As pessoas que utilizarem o sistema, poderão consultar dados estatísticos em forma de gráfico e também relatórios semanais, trimestrais e por período específico sobre a relação de tempo que foi gasto com cada categoria de atividade. Além disso, poderá ser visualizado a porcentagem de tempo que foi destinado para realização da atividade por categoria e por subcategoria.
 Apenas as pessoas que possuírem permissões (usuário comum e usuário administrador), poderão executar as funcionalidades citadas. Pessoas que possuírem permissão (administrador) poderão visualizar relatórios de outras pessoas que também utilizam o sistema, destacando que essas pessoas deverão trabalhar no mesmo setor e possuírem vínculo (gerente e subordinado) de trabalho entre se.
 O cadastro de usuários assim como informações referentes a ele serão feitas por meio do sistema externo da STI, exceto quando a pessoa que participou da atividade não faça parte do grupo de funcionário do TJES. Para essas exceções será necessário salvar nome completo da pessoa, telefone e empresa que representa, ressaltando que o sistema deve ser capaz de sugerir ao usuário o nome da empresa para seleção quando possível.</p>
 
<P align="justify">&nbsp&nbsp Os registros de eventos do sistema devem ser armazenados. A interface do sistema deverá se comportar adequadamente, independente do tamanho da tela do dispositivo que será utilizado para acesso – notebook, Smartphone ou Tablet e ser intuitiva, ou seja, simples de se trabalhar e de se aprender também, todos os botões deverão possuir ícones que representam sua função.
O sistema deve possuir opções de acessibilidade, tais como, alteração no tamanho da fonte, alto contraste, além de, seguir as Diretrizes de Acessibilidade para Conteúdo Web (WCAG).</p>

### 4.PROJECT MODEL CANVAS (PMC)<br>
 ![Alt Text](https://github.com/pauloricardo50/Daily-Log-1.1/blob/master/Imagens/PROJECT%20MODEL%20CANVAS%20(PMC).PNG)
-  [Link Para Acessar o documento.](https://docs.google.com/document/d/1LCl8LuVsgQ8qMymWssgEbuBA2PrL6HwTJfxHi1nR5sU/edit?usp=sharing)

### 5.MAPA MENTAL<br>
 ![Alt Text](https://github.com/JardielmaQueiroz/Daily-Log/blob/master/Imagens/Mapa%20Mental%20do%20Sistema.PNG?raw=true)
 
### 6. TECNOLOGIAS UTILIZADAS<br>
-  **Java:** Implementação do código fonte;
-  **MySQL Workbench:** Implementação do Banco de Dados;
-  **Balsamiq:** Protótipós;

### 6.1 PADRÕES DE PROJETO UTILIZADOS<br>
-  **_SINGLETON_** <P align="justify"> O padrão Singleton permite criar objetos únicos para os quais há apenas uma instância. Este padrão oferece um ponto de acesso global. Devido a caracteristica citada, implementamos o Singleton para controlarmos a interação com o banco de dados, com o objetivo de garantir que a classe conexão gerencie sua própria instância, além de evitar que qualquer outra classe crie uma instância dela. 
 Sempre que for necessário fazer uma conexão com o banco o metódo conectar() é chamado, ele irá verificar se já existe uma instância de Conexão, caso já existe classe sempre vai oferecer a própria instância dela e caso não tenha ainda uma instância, então ela mesma cria e retorna essa nova instância criada.</p>
 
     + O Diagrama de classe abaixo mostra mais detalhes sobre o funcionamento do padrão Singleton:
      <img src="https://github.com/pauloricardo50/Daily-Log-1.1/blob/master/Imagens/diagrama%20Singleton.PNG?raw=true" width="80%"/>
      
     + <P align="justify"> No diagrama de classe acima tem-se a classe Conexão, nessa existe o atributo conectar que é do tipo da sua própria classe e é estático, nessa variável tem-se a única instância da classe. Na classe Conexao pode-se observar que o construtor da classe Conexao() é PRIVADO. Ou seja, um construtor privado não permite que a classe seja instanciada a não ser que seja feito por ela mesmo na qual será instanciada pelo método getConexao() que é estático e assim pode ser acessado de qualquer outra classe sem precisar instanciar Conexao. 
</p>

-  **BUILDER:** <P align="justify"> Proporciona criação de diversos objetos semelhantes e Cria os novos objetos utilizando o mesmo código. Geralmente são separados por hierarquia e assim que a execução termina, o principal aproveita o construtor.
Implementamos o padrão builder foi feita para controlar os perfis de permissão dos usuários. Sabendo que no sistema teremos três perfis de usuário que são: Admintrador, Comum e Cadastro.
 
 </p>

-  **OBSERVER:** <P align="justify"> tem como objetivo manter o estado de objetos sempre atualizados através do conceito de observadores e observados. Também é utilizado para notificar quando outra pessoa adicionar uma participação na atividade. Quando um objeto mudar seu estado, todos os seus dependentes serão avisados e atualizados automaticamente. Tanto os observadores quanto os sujeitos (observados) podem ser reutilizados, já que existe um baixo acoplamento entre se. 
  Implementamos o observer para fazer o monitoramento das participações das atividades, uma vez que uma atividade é composta por participações, que podem ser participações feitas pelo dono da atividade ou não. Sendo assim sempre que uma participação for adicionada a atividade e o usuário que participou da atividade não ser o dono da mesma o usuário que participou da atividade deve ser notificado.

     + O Diagrama de classe abaixo mostra mais detalhes sobre o funcionamento do padrão Observer:
     <img src="https://github.com/pauloricardo50/Daily-Log-1.1/blob/master/Imagens/ClasseObserver.PNG?raw=true" width="90%"/>

     + <P align="justify"> No diagrama de classe acima tem-se a classe Observado, que é responsável por fazer o monitoramento de atividades que contem a lista de atividades e é responsável por registrar as atualizações. O método monitorAtividade() será utilizado para atualizar todos os observadores registrados sempre que o seu estado mudar. Existe também a interface Observador que tem o método update() que é chamado quando o estado do Observado é alterado. A classe NotSistema implementa a interface Observer, definindo assim o método update(), que será utilizado para notificar o usuário.</p>

### 7. DIÁRIO DE BORDO<br>
-  [Link Para Acessar o documento.](https://docs.google.com/document/d/1InH9X7oqH3iYVlX3xz8kX7wTIYcAmi3jNy94Y1scZEo/edit?usp=sharing)

### 8. QUADRO KANBAN<br>
-  [Trello.](https://trello.com/b/HZuN7nHJ/dailylog2)

### 10.PROTÓTIPOS DO SISTEMA(MOCKUPS)<br>
-  [MOCKUP - PERFIL USUARIO](https://github.com/pauloricardo50/Daily-Log-1.1/blob/master/Documentos/Prot%C3%B3tipos/Daily%20Log%20%20-%20Perfil%20de%20Cadastro.pdf)
-  [MOCKUP - PERFIL DE CADASTRO](https://github.com/pauloricardo50/Daily-Log-1.1/blob/master/Documentos/Prot%C3%B3tipos/Daily%20Log%20-%20Perfil%20Adiministrador.pdf)
-  [MOCKUP - PERFIL ADMINISTRADOR](https://github.com/pauloricardo50/Daily-Log-1.1/blob/master/Documentos/Prot%C3%B3tipos/Daily%20Log%20-%20Perfil%20Usuario%20Comum%20.pdf)

### 11. DIAGRAMA DE CLASSES UML<br>
 ![Alt Text](https://github.com/pauloricardo50/Daily-Log-1.1/blob/master/Imagens/Diagrama%20de%20Classe%20-%20Daily%20Log.jpg?raw=true)

### 12. DIAGRAMA DE CASO DE USO <br>
 ![Alt Text](https://github.com/pauloricardo50/Daily-Log-1.1/blob/master/Imagens/Diagrama%20de%20Caso%20de%20Uso%20-%20Daily%20Log.jpg)

### 13. MODELO CONCEITUAL <br>
 ![Alt Text](https://github.com/JardielmaQueiroz/Daily-Log/blob/master/Imagens/Modelo%20Conceitual%20DailyLog.png)

### 14. MODELO LÓGICO <br>
 ![Alt Text](https://github.com/JardielmaQueiroz/Daily-Log/blob/master/Imagens/Modelo%20Entidade%20Relacionamento%20Daily%20Log%20.png)

### 15. MODELO FÍSICO <br>
 - [Link para acessar o modelo físico](https://github.com/JardielmaQueiroz/Daily-Log/blob/master/Banco%20de%20Dados/dailylog.sql)
