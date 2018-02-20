package com.cts.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.cts.form.SkillForm;

@Component
public class SkillFormatter implements Formatter<SkillForm>{

	public SkillFormatter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String print(SkillForm object, Locale locale) {
		// TODO Auto-generated method stub
		return object.getId().toString();
	}

	@Override
	public SkillForm parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		SkillForm form = new SkillForm();
		form.setId(Integer.parseInt(text));
		return form;
	}

}
