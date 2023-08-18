package com.example.colorhunt.converters;

import com.example.colorhunt.controllers.DTO.PaletteDTO;
import com.example.colorhunt.domain.Palette;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PaletteConverter {

    Palette entityMaker(PaletteDTO paletteDTO);

    PaletteDTO dtoMaker(Palette palette);

    List<PaletteDTO> dtoListMaker(List<Palette> palettes);

    Page<PaletteDTO> pageToDTO(Page<Palette> palettes);
}
