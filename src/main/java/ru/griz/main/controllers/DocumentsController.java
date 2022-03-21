package ru.griz.main.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.griz.main.dtos.DocBuyDTO;
import ru.griz.main.entities.*;
import ru.griz.main.services.DocumentsService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/doc")
@RequiredArgsConstructor
public class DocumentsController {

    private final DocumentsService documentsService;

    // Все документы
    @GetMapping("/")
    public List<Document> getAllDocs() {
        return documentsService.getAllDocs();
    }

    @GetMapping("/{id}")
    public Document getByIdDoc(@PathVariable Long id) {
        return documentsService.getByIdDoc(id);
    }

    // Поступления
    @GetMapping("/buy/")
    public List<BuyHeader> getAllDocBuys() {
        return documentsService.getAllDocBuys();
    }

    @GetMapping("/buy/{id}")
    public BuyHeader getByIdDocBuy(@PathVariable Long id) {
        return documentsService.getByIdDocBuy(id);
    }

    @GetMapping("/buy/items/{docId}")
    public List<BuyItem> getDocBuyItems(@PathVariable long docId) {
        return documentsService.getDocBuyItems(docId);
    }

    @GetMapping("/buy/dto/{id}")
    public DocBuyDTO getDocBuyDto(@PathVariable long id) {
        return documentsService.getDocBuyDTO(id);
    }

    @PostMapping("/buy/")
    public DocBuyDTO postDocBuy(@RequestBody DocBuyDTO doc) {
        return documentsService.saveDocBuy(doc);
    }

    // Отгрузки
    @GetMapping("/sale/")
    public List<SaleHeader> getAllDocSales() {
        return documentsService.getAllDocSales();
    }

    @GetMapping("/sale/{id}")
    public SaleHeader getByIdDocSale(@PathVariable Long id) {
        return documentsService.getByIdDocSale(id);
    }

    @GetMapping("/sale/items/{docId}")
    public List<SaleItem> getDocSaleItems(@PathVariable long docId) {
        return documentsService.getDocSaleItems(docId);
    }

    // Возвраты
    @GetMapping("/return/")
    public List<ReturnHeader> getAllDocReturns() {
        return documentsService.getAllDocReturns();
    }

    @GetMapping("/return/{id}")
    public ReturnHeader getByIdDocReturn(@PathVariable Long id) {
        return documentsService.getByIdDocReturn(id);
    }

    @GetMapping("/return/items/{docId}")
    public List<ReturnItem> getDocReturnItems(@PathVariable long docId) {
        return documentsService.getDocReturnItems(docId);
    }

}
