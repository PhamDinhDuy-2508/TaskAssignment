package com.task.assignment.Facade.UserFacadeImpl;
import com.task.assignment.Configuration.Details.UserInfoDetail;
import com.task.assignment.DTO.RegisterDTO;
import com.task.assignment.DTO.UserAuthenticationRequestDTO;
import com.task.assignment.DTO.UserAuthenticationResponseDTO;
import com.task.assignment.Entity.User;
import com.task.assignment.Facade.UserFacade;
import com.task.assignment.Services.AuthenticationService.AuthenticationServices;
import com.task.assignment.Services.Converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userFacade")
public class UserFacadeImpl implements UserFacade {
    private Converter<UserAuthenticationResponseDTO , UserInfoDetail> converter ;
    private Converter<RegisterDTO , User> registerConverter ;
    private AuthenticationServices authenticationServices ;
    @Override
    public UserAuthenticationResponseDTO authentication(UserAuthenticationRequestDTO requestDTO) {
        UserInfoDetail userInfoDetail  = authenticationServices.authentication(requestDTO) ;
        return converter.convertToDTO(userInfoDetail);
    }

    @Override
    public void register(RegisterDTO requestDTO) {
        authenticationServices.register(registerConverter.convertToEntity(requestDTO)) ;
    }

    @Override
    public Boolean checkUserExisted(String name) {
        return authenticationServices.getUser(name) == null;
    }

    @Autowired
    @Qualifier("authConverter")
    public void setConverter(Converter<UserAuthenticationResponseDTO, UserInfoDetail> converter) {
        this.converter = converter;
    }
    @Autowired
    @Qualifier("authenticationService")
    public void setAuthenticationServices(AuthenticationServices authenticationServices) {
        this.authenticationServices = authenticationServices;
    }
    @Autowired
    @Qualifier("registerConverter")
    public void setRegisterConverter(Converter<RegisterDTO, User> registerConverter) {
        this.registerConverter = registerConverter;
    }
}
