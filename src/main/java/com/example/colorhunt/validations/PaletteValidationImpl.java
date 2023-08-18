package com.example.colorhunt.validations;

import com.example.colorhunt.domain.Palette;
import com.example.colorhunt.exceptions.ResourceNotFoundException;
import com.example.colorhunt.repositories.PaletteRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Value
@RequiredArgsConstructor
@Service
public class PaletteValidationImpl implements PaletteValidation {

    PaletteRepository paletteRepository;

    @Override
    public Palette validateID(Long paletteId) {
        var palette = paletteRepository.findById(paletteId);

        if (palette.isEmpty())
            throw new ResourceNotFoundException("Palette with id " + paletteId + " Not fount");
        return palette.get();
    }
}
