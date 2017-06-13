var Advocacia = Advocacia || {};

Advocacia.EstiloCadastroRapido = (function(){
	
	function EstiloCadastroRapido(){
		this.modal = $('#modalVisualizarCliente');
		this.botaoSalvar = this.modal.find('.js-modal-cadastro-estilo-salvar-btn');
		this.form = this.modal.find('form');
		this.containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo');
		this.url = this.form.attr('action');
		this.inputNomeEstilo = $('#nomeEstilo');
	}
	
	EstiloCadastroRapido.prototype.iniciar = function() {
		this.form.on('submit', function(event) { event.preventDefault() });
		this.modal.on('shown.bs.modal', onModalShow.bind(this));
		this.modal.on('hide.bs.modal', onModalClose.bind(this));
	}
	
	function onModalShow() {
		this.inputNomeEstilo.focus();
	}
	
	function onModalClose(){
		this.inputNomeEstilo.val('');
		this.containerMensagemErro.addClass('hidden');
		this.form.find('.form-group').removeClass('has-error');
	}
	
	
	}
	
	
	
	return EstiloCadastroRapido;
	
}());

$(function(){	
	var estiloCadastroRapido = new Advocacia.EstiloCadastroRapido();
	estiloCadastroRapido.iniciar();
});