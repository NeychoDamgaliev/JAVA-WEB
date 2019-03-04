package realestate.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realestate.domain.models.binding.OfferFindBindingModel;
import realestate.repository.OfferRepository;
import realestate.domain.entities.Offer;
import realestate.domain.models.service.OfferServiceModel;

import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Neycho Damgaliev on 3/4/2019.
 */

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, Validator validator, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerOffer(OfferServiceModel offerServiceModel) {
       if(this.validator.validate(offerServiceModel).size() !=0 ) {
            throw new IllegalArgumentException("Something went wrong!");
       }
       this.offerRepository.saveAndFlush(this.modelMapper.map(offerServiceModel, Offer.class));
    }

    @Override
    public List<OfferServiceModel> findAllOffers() {
        return this.offerRepository.findAll()
                .stream()
                .map(offer -> this.modelMapper.map(offer,OfferServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void findOffer(OfferFindBindingModel offerFindBindingModel) {
        if(this.validator.validate(offerFindBindingModel).size() != 0) {
            throw new IllegalArgumentException("Something went wrong!");
        }
        Offer offer = this.offerRepository.findAll().stream()
                .filter(o->o.getApartmentType().toLowerCase().equals(offerFindBindingModel.getFamilyApartmentType().toLowerCase())
                && offerFindBindingModel.getFamilyBudget().compareTo(
                        o.getApartmentRent().add(
                                o.getAgencyCommission().divide(new BigDecimal("100")).multiply(o.getApartmentRent())
                                )) >= 0)
                .map(o->this.modelMapper.map(o,Offer.class))
                .findFirst()
                .orElse(null);

        if(offer==null) {
            throw new IllegalArgumentException("Something went wrong!");
        }
        this.offerRepository.delete(offer);
    }
}
