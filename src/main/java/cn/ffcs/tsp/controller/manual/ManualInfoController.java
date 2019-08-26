package cn.ffcs.tsp.controller.manual;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import cn.ffcs.tsp.entity.ManualInfo;
import cn.ffcs.tsp.service.manual.IManualService;
@Controller
@Path(value = "/manualInfo")
public class ManualInfoController extends Test<ManualInfo>{
	@Resource
	private IManualService manualService ;
	
	@Autowired
	private ApplicationContext ctx;
	
	@Override
	public IManualService test2(){
		//启动项目时就会执行此方法,调用其他方法时，该方法不执行
		System.out.println("11111");
		return manualService;
		
	}
	/**
	 * 保存对象
	 * @param manualInfo
	 */
	@Path("/manual")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save( ManualInfo manualInfo){
		manualInfo.setAutoEnterpriseCode("test");
		manualInfo.setDowloadUrl("test");
		manualInfo.setManualName("test");
		manualService.save(manualInfo);
	}
	
	/**
	 * 修改某个对象
	 * @param manualInfo
	 */
	@Path("/manual/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void update(@PathParam(value = "id") Long id, ManualInfo manualInfo){
		manualInfo.setId(id);
		manualService.update(manualInfo);
	}
	
	/**
	 * 获取对象列表
	 * @return
	 */
	@Path("/manual")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ManualInfo> findAll(){
		return manualService.findAll();
	}
	
	
	/**
	 * 
	 * 获取单个对象
	 * @param id
	 * @return
	 */
	@Path("manual/{id}")
	@GET
//	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ManualInfo findById(@PathVariable String id, @QueryParam(value = "msg") String msg){
		System.out.println(ctx.getBeansOfType(ManualInfoController.class));
		IManualService manualService = ctx.getBean("manualServiceImpl",IManualService.class);
		return manualService.findById(id);
	}
//	
//	/**
//	 * 
//	 * 获取多个对象
//	 */
//	@Path("/{ids}/manual")
//	@GET
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	 public List<ManualInfo> findByIds(@PathVariable String ids){
//		String[] str = ids.split(",");
//		 return manualService.findByIds(str);
//	 }
//	 
//	/**
//	 * 
//	 * 返回多个对象
//	 * @param map
//	 * @return
//	 */
//	@Path("/{jsonStr}/manual")
//	@GET
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<ManualInfo> findByMap(@PathVariable String jsonStr){
//		
//		return manualService.findByMap(new HashMap<String,Object>());
//	}
//	 
//	/**
//	 * 
//	 * 返回多个对象
//	 * @param page
//	 * @param map
//	 * @return
//	 */
//	@Path("/{jsonStr}/list")
//	@GET
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<ManualInfo> findByPage(@PathVariable String jsonStr){
//		Page page = new Page();
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("startRowNum", page.getStartRowNum());
//		map.put("pageSize", page.getPageSize());
//		return manualService.findByPage(page,map);
//	}
//	
//	/**
//	 * 
//	 * 报存多个对象
//	 * @param list
//	 */
//	@Path("/{list}/manualInfo")
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public void saveList(List<ManualInfo> list){
//		manualService.saveList(list);
//	}

//	@Path("/{ids}")
//	@DELETE
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public void deleteByIds(@PathVariable String ids){
//		manualService.deleteByIds(new ArrayList<Long>());
//	}
//	
//	/**
//	 * 批量修改
//	 */
//	@Path("/{list}")
//	@PUT
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public void updateByIds(@PathVariable List<String> list){
//		manualService.updateByIds(list);
//	}
}
