package com.cts.initconfig;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.cts.dto.ConfiguredSkillsList;
import com.cts.form.SkillForm;
import com.cts.svc.ICandidateDetailsSvc;

@Component
public class LoadApplicationData implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ICandidateDetailsSvc candidateSvc;
	
	@Autowired
	private ConfiguredSkillsList configuredSkillsList;
	
	private static final Logger logger = Logger.getLogger(LoadApplicationData.class);
	
	@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       //do something if all apps have initialised
		List<SkillForm> skills = candidateSvc.listAllSkills();
		if (logger.isDebugEnabled()) {
			logger.debug("-------onApplicationEvent------"+skills);
		}
		configuredSkillsList.setSkillList(skills);
    }

}
