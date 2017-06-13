var Advocacia = Advocacia || {};

Advocacia.MaskMoney = (function() {

	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	}

	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney({
			decimal : ',',
			thousands : '.'
		});
		this.plain.maskMoney({
			precision : 0,
			thousands : '.'
		});
	}

	return MaskMoney;

}());

Advocacia.MaskPhoneNumber = (function() {
	
	function MaskPhoneNumber() {
		this.inputPhoneNumber = $('.js-phone-number');
	}
	
	MaskPhoneNumber.prototype.enable = function() {
		var maskBehavior = function (val) {
		  return val.replace(/\D/g, '').length === 11 ? '(00) 0 0000-0000' : '(00) 0000-00009';
		};
		
		var options = {
		  onKeyPress: function(val, e, field, options) {
		      field.mask(maskBehavior.apply({}, arguments), options);
		    }
		};
		
		this.inputPhoneNumber.mask(maskBehavior, options);
	}
	
	return MaskPhoneNumber;
	
}());

Advocacia.MaskCep = (function(){
	
	function MaskCep() {
		this.inputCep = $('.js-cep');
	}
	
	MaskCep.prototype.enable = function() {
		this.inputCep.mask('00.000-000');
	}
	
	return MaskCep;
	
}());

$(function() {
	var maskMoney = new Advocacia.MaskMoney();
	maskMoney.enable();
	
	var maskCep = new Advocacia.MaskCep();
	maskCep.enable();
	
	var maskPhoneNumber = new Advocacia.MaskPhoneNumber();
	maskPhoneNumber.enable();
	
	
	
});