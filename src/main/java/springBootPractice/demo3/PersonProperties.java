package springBootPractice.demo3;

	import org.springframework.boot.context.properties.ConfigurationProperties;
	import org.springframework.stereotype.Component;

	@Component
	@ConfigurationProperties(prefix = "person")
	public class PersonProperties {
	    private String name;
	    private Integer age;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Integer getAge() {
	        return age;
	    }

	    public void setAge(Integer age) {
	        this.age = age;
	    }
	}
