package furamaResort.services;

import furamaResort.libs.CheckValid;
import furamaResort.models.Booking;
import furamaResort.models.Contract;
import furamaResort.utils.ReadAndWrite;
import furamaResort.utils.ValidateInputData;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class ContractIplm implements ContractService {
    //list
    private static Collection<Contract> contractList = new ArrayList<>();
    //file contract
    private static ReadAndWrite<Contract> contractFile = new ReadAndWrite<>();
    private static final String PATH_CONTRACT = "D:\\module2\\src\\furamaResort\\data\\contract.csv";
    //file booking mới - cần HĐ:
    private static ReadAndWrite<Booking> bookingNeedContractFile = new ReadAndWrite<>();
    private static final String PATH_WAITING_CONTRACT = "src\\furamaResort\\data\\bookingWaitingContract.csv";

    static {
        contractList = contractFile.readData(new File(PATH_CONTRACT));
    }

    @Override
    public void display() { //ok
        if (contractList.isEmpty()) {
            System.out.println("List contract is EMPTY!");
        } else {
            for (Contract contract : contractList) {
                System.out.println(contract);
            }
        }
    }

    @Override
    public void creatNewContract() {
        //chuyển Set --> Queue:
        java.util.Queue<Booking> queue = new LinkedList<>(BookingServiceIplm.bookingNeedContractSet);
        if (queue.isEmpty()) {
            System.err.println("No Booking to make Contract! ");
        }
        Booking booking = null;
        if (!queue.isEmpty()) {
            // pop từng phần tử ra khỏi queue --> check isVilla/isHouse ??
            booking = queue.poll();
            System.err.println("Booking : " + booking);
            String[] arrServiceCode = booking.getServiceName().split("-");
            if (arrServiceCode[0].equals("SVVL") || arrServiceCode[0].equals("SVHO")) {
                //nhap contractCode - check duplicated:
                String contractCode = isCodeDuplicated();
                //nhap tien coc:
                System.out.println("Enter deposit: ");
                double deposit = CheckValid.checkFloatException();
                System.out.println("Enter total payment: ");
                double totalPayment = CheckValid.checkFloatException();
                //Lưu file contract
                contractList.add(new Contract(contractCode, booking.getBookingId(), deposit, totalPayment, booking.getCustomerId()));
                contractFile.writeData(PATH_CONTRACT, contractList);
                System.out.println("Contract has been created ");
            }
        }
        BookingServiceIplm.bookingNeedContractSet.remove(booking); //update lại file booking mới
        bookingNeedContractFile.writeData(PATH_WAITING_CONTRACT, BookingServiceIplm.bookingNeedContractSet);
    }

    public static String isCodeDuplicated() {  //check code trùng?
        String contractCode = null;
        boolean check = false;
        while (!check) {
            int count = 0;
            contractCode = ValidateInputData.contractCode();
            for (Contract contract : contractList) {
                if (!contractCode.equals(contract.getContractCode())) {
                    count++;
                }
            }
            if (count == contractList.size()) {
                System.out.println("ok");
                check = true;
            } else {
                System.err.println("Contract Code cannot be duplicated! Please enter again: ");
            }
        }
        return contractCode;
    }

    @Override
    public void editContract() {
        boolean check = false;
        while (!check) {
            String contractId = ValidateInputData.contractCode();
            for (Contract contract : contractList) {
                if (contractId.equals(contract.getContractCode())) {
                    System.out.println("Enter deposit: ");
                    contract.setDeposit(CheckValid.checkFloatException());
                    System.out.println("Enter total payment: ");
                    contract.setTotalPayment(CheckValid.checkFloatException());
                    contractFile.writeData(PATH_CONTRACT, contractList);
                    System.out.println("Contract has been edited ");
                    check = true;
                }
            }
            if (!check) {
                System.out.println("NOT found this Contract ID! Please try again: ");
            }
        }
    }
}
