package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.business.dto.requests.create.CreateModelRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateModelResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllModelsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetModelResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateModelResponse;
import kodlama.io.rentacar.entities.Model;
import kodlama.io.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;

    private final ModelMapper mapper;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models=modelRepository.findAll();
        List<GetAllModelsResponse>responses=models.stream()
                .map(model -> mapper.map(model,GetAllModelsResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetModelResponse getById(int id) {
        checkIfModelExists(id);

        Model model=modelRepository.findById(id).orElseThrow();
        GetModelResponse responses=mapper.map(model,GetModelResponse.class);
        return responses;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        Model model=mapper.map(request,Model.class);
        modelRepository.save(model);
        CreateModelResponse responses=mapper.map(model,CreateModelResponse.class);
        return responses;

    }


    public UpdateModelResponse update (int id , UpdateModelRequest updateModelRequest){
        checkIfModelExists(id);


        Model model =mapper.map(updateModelRequest,Model.class);
        model.setId(id);
        modelRepository.save(model);
        UpdateModelResponse updateModelResponse=mapper.map(model,UpdateModelResponse.class);
        return updateModelResponse;
    }

    @Override
    public void delete(int id){
        checkIfModelExists(id);
        modelRepository.deleteById(id);
    }
    private void checkIfModelExists(int id) {
        if(!modelRepository.existsById(id)) {
            throw new RuntimeException("Böyle bir model bulunamadı!");
        }
    }
}
