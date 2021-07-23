package ec.edu.ups.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bean {
	private String name = "Soy bean";
	private String[] array = { "cero", "uno", "dos" };
	private List<String> list = new ArrayList<String>();
	private Map<String, String> map = new HashMap<String, String>();
	private Bean2 bean2 = new Bean2();

	public Bean() {
		this.list.add("cero");
		this.list.add("uno");
		this.map.put("cero", "0");
		this.map.put("uno", "1");
	}

	public int method(int v) {
		return v * 3;
	}

	public int method2() {
		return 2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Bean2 getBean2() {
		return bean2;
	}

	public void setBean2(Bean2 bean2) {
		this.bean2 = bean2;
	}

}
