package cn.ffcs.tsp.service.manual.impl;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ffcs.tsp.entity.ManualInfo;
import cn.ffcs.tsp.mapper.ManualInfoMapper;
import cn.ffcs.tsp.service.manual.IManualService;
import cn.ffcs.tsp.util.Page;

@Service 
public class ManualServiceImpl implements IManualService{

    @Resource
	public ManualInfoMapper manualInfoMapper ;
	
	public List<ManualInfo> findAll() {
		return manualInfoMapper.findAll();
	}

	@Override
	public ManualInfo findById(String id) {
		return manualInfoMapper.findById(id);
	}

	@Override
	public void save(ManualInfo manualInfo) {
		 manualInfoMapper.save(manualInfo) ;
	}

	@Override
	public void update(ManualInfo manualInfo) {
		manualInfoMapper.update(manualInfo) ;
	}

	@Override
	public List<ManualInfo> findByMap(Map<String, Object> map) {
		return manualInfoMapper.findByMap(map);
	}

	@Override
	public List<ManualInfo> findByPage(Page page, Map<String, Object> map) {
		return manualInfoMapper.findByPage(map);
	}

	@Override
	public void saveList(List<ManualInfo> list) {
		manualInfoMapper.saveList(list);
	}

	@Override
	public List<ManualInfo> findByIds(String[] ids) {
		return manualInfoMapper.findByIds(ids);
	}

	@Override
	public void deleteByIds(List<Long> list) {
		manualInfoMapper.deleteByIds(list);
	}

	@Override
	public void updateByIds(List<String> list) {
		manualInfoMapper.updateByIds(list);
	}

}
