package cloud.oauth2.server.config;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import cloud.oauth2.server.domain.GlobalConstant;

import javax.servlet.http.HttpServletRequest;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    private static final long serialVersionUID = 6975601077710753878L;
    private final String inputVerificationCode;
    private final String graphId;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        inputVerificationCode = request.getParameter(GlobalConstant.VERIFICATION_CODE);
        graphId = request.getParameter(GlobalConstant.GRAPH_ID);
    }

    public String getInputVerificationCode() {
        return inputVerificationCode;
    }

    public String getGraphId() {
        return graphId;
    }

    @Override
    public String toString() {
        return super.toString() + "; inputVerificationCode: " + this.getInputVerificationCode() + "; graphId: " + this.getGraphId();
    }
}
