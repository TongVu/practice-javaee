package resource;

import service.DepartmentService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(DepartmentResource.PATH)
public class DepartmentResource {
    public static final String PATH = "departments";

    @Inject
    DepartmentService departmentService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll(){
        return Response.ok(departmentService.getAll()).build();
    }
}
