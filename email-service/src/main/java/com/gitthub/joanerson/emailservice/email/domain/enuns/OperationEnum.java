package com.gitthub.joanerson.emailservice.email.domain.enuns;

public enum OperationEnum {
	ORDEM_CRIADA {
		@Override
		public String mensagem() {
			return "Ordem de serviço criada com sucesso";
		}
	},
	ORDEM_ATUALIZADA {
		@Override
		public String mensagem() {
			return "Ordem de serviço atualizada com sucesso";
		}
	},
	ORDEM_DELETADA {
		@Override
		public String mensagem() {
			return "Ordem de serviço deletada com sucesso";
		}
	};

	public abstract String mensagem();
}
