package ru.griz.main.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.griz.main.dtos.DocBuyDTO;
import ru.griz.main.entities.*;
import ru.griz.main.exceptions.ResourceNotFoundException;
import ru.griz.main.repositories.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentsService {

    private final DocumentsRepository documentsRepository;
    private final BuyRepository buyRepository;
    private final BuyItemRepository buyItemRepository;
    private final SaleRepository saleRepository;
    private final SaleItemRepository saleItemRepository;
    private final ReturnRepository returnRepository;
    private final ReturnItemRepository returnItemRepository;

    private Supplier<ResourceNotFoundException> documentNotFound(Long id) {
        return () -> new ResourceNotFoundException("Document: " + id + " not found");
    }

    // Все документы
    public List<Document> getAllDocs() {
        return documentsRepository.findAll();
    }

    public Document getByIdDoc(Long id) {
        return documentsRepository.findById(id)
                .orElseThrow(documentNotFound(id));
    }

    // Поступления
    public List<BuyHeader> getAllDocBuys() {
        return buyRepository.findAll();
    }

    public BuyHeader getByIdDocBuy(Long id) {
        return buyRepository.findById(id)
                .orElseThrow(documentNotFound(id));
    }

    public List<BuyItem> getDocBuyItems(long docId) {
        return buyItemRepository.findAllByDocId(docId);
    }

    public DocBuyDTO saveDocBuy(DocBuyDTO doc) {
        log.info("POST: id: {} date {}", doc.getId(), doc.getDate());
        Document document = new Document();
        document.setId(doc.getId());
        document.setType("BUY");
        document = documentsRepository.save(document);
        BuyHeader header = new BuyHeader();
        header.setId(document.getId());
        try {
            header.setDate(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(doc.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
            header.setDate(new Date());
        }
        header = buyRepository.save(header);
        Long id = header.getId();

        DocBuyDTO result = new DocBuyDTO();
        result.setId(id);
        result.setDate(doc.getDate());
//        result.setDate(header.getDate());

        if (doc.getId() != null) {
            buyItemRepository.deleteAllByDocId(doc.getId());
        }
        doc.getItems().forEach(i -> {
            i.setDocId(id);
            result.getItems().add(i);
        });
        List<BuyItem> resultItems = buyItemRepository.saveAll(result.getItems());
        result.setItems(resultItems);
        return null;
    }

    // Отгрузки
    public List<SaleHeader> getAllDocSales() {
        return saleRepository.findAll();
    }

    public SaleHeader getByIdDocSale(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(documentNotFound(id));
    }

    public List<SaleItem> getDocSaleItems(long docId) {
        return saleItemRepository.findAllByDocId(docId);
    }

    // Возвраты
    public List<ReturnHeader> getAllDocReturns() {
        return returnRepository.findAll();
    }

    public ReturnHeader getByIdDocReturn(Long id) {
        return returnRepository.findById(id)
                .orElseThrow(documentNotFound(id));
    }

    public List<ReturnItem> getDocReturnItems(long docId) {
        return returnItemRepository.findAllByDocId(docId);
    }
}
