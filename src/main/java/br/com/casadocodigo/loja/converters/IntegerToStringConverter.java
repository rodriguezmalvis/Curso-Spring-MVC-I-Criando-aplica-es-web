package br.com.casadocodigo.loja.converters;

import org.springframework.core.convert.converter.Converter;

public class IntegerToStringConverter implements Converter<Integer, String>{

	@Override
	public String convert(Integer integer) {
		return integer.toString();
	}

}
