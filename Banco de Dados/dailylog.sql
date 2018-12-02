
--
-- Banco de Dados: `daylog`
--

--
-- Estrutura da tabela `tbl_permissao`
--

CREATE TABLE IF NOT EXISTS `tbl_permissao` (
  `id_permisao` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  
PRIMARY KEY (`id_permisao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=5;

--
-- Extraindo dados da tabela `tbl_permissao`
--

INSERT INTO `tbl_permissao` (`id_permisao`, `descricao`) VALUES
(1, 'CREATE'),
(2, 'READ'),
(3, 'UPDATE'),
(4, 'DELETE'),
(5, 'MANAGEMENT');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_perfil`
--

CREATE TABLE IF NOT EXISTS `tbl_perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `id_permisao` int(11) NOT NULL,
  `descricao` varchar(20) NOT NULL,
  `horarioPadraoInicial` time NOT NULL,
  `horarioPadraoFinal` time NOT NULL,
  `tamanhoFonte` int(11) NOT NULL,
  `autoContraste` boolean NOT NULL,
  
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=4;

--
-- Extraindo dados da tabela `tbl_perfil`
--

INSERT INTO `tbl_perfil` (`id_perfil`, `descricao`, `horarioPadraoInicial`, `horarioPadraoFinal`, `tamanhoFonte`, `autoContraste`) VALUES
(1, 'Cadastro', '12:00:00', '18:00:00', 12, 0),
(2, 'Administrador', '12:00:00', '18:00:00', 12, 0),
(3, 'Usuario', '12:00:00', '18:00:00', 12, 0);

-- --------------------------------------------------------

-- Estrutura da tabela `tbl_permisaoPerfil`
--

CREATE TABLE IF NOT EXISTS `tbl_permisaoPerfil` (
  `tbl_permisaoPerfil` int(11) NOT NULL AUTO_INCREMENT,
  `id_permisao` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  
  PRIMARY KEY (`tbl_permisaoPerfil`),
  CONSTRAINT fk_permisaoPerfil FOREIGN KEY (id_permisao) REFERENCES tbl_permissao(id_permisao),
  CONSTRAINT fk_perfilPermissao FOREIGN KEY (id_perfil) REFERENCES tbl_perfil(id_perfil)

) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=12;

--
-- Extraindo dados da tabela `tbl_permisaoperfil`
--

INSERT INTO `tbl_permisaoperfil` (`tbl_permisaoPerfil`, `id_permisao`, `id_perfil`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 1),
(5, 2, 2),
(6, 2, 3),
(7, 3, 1),
(8, 3, 2),
(9, 3, 3),
(10, 4, 1),
(11, 4, 2),
(12, 4, 3);

-- --------------------------------------------------------
--
-- Estrutura da tabela `tbl_usuario`
--

CREATE TABLE IF NOT EXISTS `tbl_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_perfil` int(11) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `flag_ativo` varchar(1) NOT NULL,
  
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT fk_UserPerfil FOREIGN KEY (id_perfil) REFERENCES tbl_perfil (id_perfil)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=8;

--
-- Extraindo dados da tabela `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`id_usuario`, `id_perfil`, `senha`, `nome`, `flag_ativo`) VALUES
(1, 1, '123', 'Jardielma', 'A'),
(2, 2, '123', 'Paulo Ricardo', 'A'),
(3, 3, '123', 'Eduardo', 'A'),
(4, 1, '123', 'João Paulo', 'A'),
(5, 1, '123', 'André', 'A'),
(6, 1, '123', 'Eliana', 'A'),
(7, 2, '12345', 'Joselma', 'A'),
(8, 1, '1234', 'Maria', 'A');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_expediente`
--

CREATE TABLE IF NOT EXISTS `tbl_expediente` (
  `id_expediente` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `horarioInicio` time NOT NULL,
  `horarioFim` time NOT NULL,
  `flag_ativo` varchar(1) NOT NULL,

  `data` date NOT NULL,
 
  PRIMARY KEY (`id_expediente`),
  CONSTRAINT fk_ExpedienteUsuario FOREIGN KEY (id_usuario) REFERENCES tbl_usuario(id_usuario)

) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `tbl_expediente`
--

INSERT INTO `tbl_expediente` (`id_expediente`, `id_usuario`, `horarioInicio`, `horarioFim`, `data`, `flag_ativo`) VALUES
(1, 2, '13:00:00', '19:00:00', '2012-10-10', 'A'),
(2, 1, '10:00:00', '18:00:00', '2111-11-11', 'A');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_atividade`
--

CREATE TABLE IF NOT EXISTS `tbl_atividade` (
  `id_atividade` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(30) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `horarioInicio` time NOT NULL,
  `horarioFim` time NOT NULL,
  `data` date NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_expediente` int(11) NOT NULL,
  `id_subcategoria`int(11) NOT NULL,

  PRIMARY KEY (`id_atividade`),
  CONSTRAINT fk_UserUsuario FOREIGN KEY (id_usuario) REFERENCES tbl_usuario(id_usuario),
  CONSTRAINT fk_Expediente FOREIGN KEY (id_expediente) REFERENCES tbl_expediente(id_expediente)
  
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_participacaoAtividade`
--

CREATE TABLE IF NOT EXISTS `tbl_participacaoAtividade` (
  `id_participacaoAtividade` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  `horarioInicio` time NOT NULL,
  `horarioFim` time NOT NULL,
  `id_atividade` int(11) NOT NULL,
  
  PRIMARY KEY (`id_participacaoAtividade`),
  CONSTRAINT fk_ParticipacaoAtividade FOREIGN KEY (id_atividade) REFERENCES tbl_atividade(id_atividade)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_categoria`
--

CREATE TABLE IF NOT EXISTS `tbl_categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `tbl_categoria`
--

INSERT INTO `tbl_categoria` (`id_categoria`, `descricao`) VALUES
(1, 'Reunião'),
(2, 'Comunicação'),
(3, 'Evento'),
(4, 'Contrato'),
(5, 'Treinamento');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_subcategoria`
--

CREATE TABLE IF NOT EXISTS `tbl_subcategoria` (
  `id_subcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_subcategoria`),
  CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES tbl_categoria(id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=23;

--
-- Extraindo dados da tabela `tbl_subcategoria`
--

INSERT INTO `tbl_subcategoria` (`id_subcategoria`, `descricao`, `id_categoria`) VALUES
(1, 'Pessoa Interna e externa ', 1),
(2, 'Equipe de setor ', 1),
(3, 'Equipe de sistema externo ', 1),
(4, ' Definição de escopo de projet', 1),
(5, 'Demanda', 1),
(6, 'Presidência', 1),
(7, 'Verificação de Email', 2),
(8, 'Trello ', 2),
(9, ' Sistema SEI ', 2),
(10, 'Pronunciamento', 2),
(11, 'E-diario', 2),
(12, ' Pessoal Interno ', 3),
(13, ' Pessoal Externo ', 3),
(14, 'Aniverariantes do Mês', 3),
(15, 'Presidência ', 3),
(16, 'Extra Oficial', 3),
(17, 'Recisão', 4),
(18, 'Assinatura', 4),
(19, 'Renovação', 4),
(20, 'Sistema Interno', 5),
(21, 'Sistema Externo', 5),
(22, 'Ambientação de  Estagiário ', 5),
(23, 'Equipes', 5);

-- --------------------------------------------------------
