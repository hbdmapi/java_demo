package com.huobi.common.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpException;

import com.alibaba.fastjson.JSON;
import com.huobi.common.request.Order;
import com.huobi.common.util.HbdmHttpClient;

public class HbdmswapRestApiV1 implements IHbdmswapRestApi {

	private String secret_key;

	private String api_key;

	private String url_prex;

	public HbdmswapRestApiV1(String url_prex, String api_key, String secret_key) {
		this.api_key = api_key;
		this.secret_key = secret_key;
		this.url_prex = url_prex;
	}

	public HbdmswapRestApiV1(String url_prex) {
		this.url_prex = url_prex;

	}

	public static final String HUOBI_FUTURE_TICKER = "/swap-ex/market/detail/merged";
	public static final String HUOBI_FUTURE_DEPTH = "/swap-ex/market/depth";
	public static final String HUOBI_FUTURE_KLINE = "/swap-ex/market/history/kline";
	public static final String HUOBI_FUTURE_TRADE = "/swap-ex/market/history/trade";

	// 获取合约信息 /v1/contract_contract_info
	public static final String HUOBI_FUTURE_CONTRACT_INFO = "/swap-api/v1/swap_contract_info";
	// 获取合约指数v1/contract_index
	public static final String HUOBI_FUTURE_CONTRACT_INDEX = "/swap-api/v1/swap_index";
	// 获取合约最低最高限价/v1/contract_price_limit
	public static final String HUOBI_FUTURE_CONTRACT_PRICE_LIMIT = "/swap-api/v1/swap_price_limit";

	// 获取合约总持仓量
	public static final String HUOBI_FUTURE_CONTRACT_OPEN_INTEREST = "/swap-api/v1/swap_open_interest";

	// 订单明细
	public static final String HUOBI_FUTURE_CONTRACT_ORDER_DETAIL = "/swap-api/v1/swap_order_detail";

	public static final String HUOBI_FUTURE_CONTRACT_HISORDERS = "/swap-api/v1/swap_hisorders";

	// 批量下单contract_batchorder
	public static final String HUOBI_FUTURE_CONTRACT_BATCHORDER = "/swap-api/v1/swap_batchorder";
	// account相关
	public static final String HUOBI_FUTURE_ACCOUNT_INFO = "/swap-api/v1/swap_account_info";
	public static final String HUOBI_FUTURE_POSITION_INFO = "/swap-api/v1/swap_position_info";
	public static final String HUOBI_FUTURE_ORDER = "/swap-api/v1/swap_order";
	public static final String HUOBI_FUTURE_ORDER_CANCEL = "/swap-api/v1/swap_cancel";
	public static final String HUOBI_FUTURE_ORDER_INFO = "/swap-api/v1/swap_order_info";
	public static final String HUOBI_FUTURE_ORDER_CANCEL_ALL = "/swap-api/v1/swap_cancelall";
	public static final String HUOBI_CONTRACE_CODE = "/swap-api/v1/swap_open_interest";
	public static final String HUOBI_CONTRACE_OPENORDERS = "/swap-api/v1/swap_openorders";

	@Override
	public String futureContractInfo(String contractCode) {
		Map<String, String> params = new HashMap<>();
		
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		String contractinfoRes = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_CONTRACT_INFO, params);
		return contractinfoRes;
	}

	@Override
	public String futureContractIndex(String contractCode) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		String contractindexRes = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_CONTRACT_INDEX,
				params);
		return contractindexRes;
	}

	@Override
	public String futurePriceLimit(String contractCode)
			throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		String contractinfoRes = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_CONTRACT_PRICE_LIMIT,
				params);
		return contractinfoRes;
	}

	@Override
	public String futureOpenInterest(String contractCode)
			throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		String contractinfoRes = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_CONTRACT_OPEN_INTEREST,
				params);
		return contractinfoRes;
	}

	public String futureMarketDepth(String contractCode, String type) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		if (!StringUtils.isEmpty(type)) {
			params.put("type", type);
		}
		String contractinfoRes = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_DEPTH, params);
		return contractinfoRes;
	}

	public String futureMarketHistoryKline(String contractCode, String period,String size) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		if (!StringUtils.isEmpty(period)) {
			params.put("period", period);
		}
		if (!StringUtils.isEmpty(size)) {
			params.put("size", size);
		}
		String res = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_KLINE, params);
		return res;
	}

	public String futureMarketDetailMerged(String contractCode) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}		
		String res = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_TICKER, params);
		return res;
	}

	public String futureMarketDetailTrade(String contractCode, String size) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		if (!StringUtils.isEmpty(size)) {
			params.put("size", size);
		}
		String res = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_TRADE, params);
		return res;
	}

	public String futureMarketHistoryTrade(String contractCode, String size) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		if (!StringUtils.isEmpty(size)) {
			params.put("size", size);
		}
		String res = HbdmHttpClient.getInstance().doGet(url_prex + HUOBI_FUTURE_TRADE, params);
		return res;
	}

	public String futureContractAccountInfo(String contractCode) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}

		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_ACCOUNT_INFO, params, new HashMap<>());
		return res;
	}

	public String futureContractPositionInfo(String contractCode) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}

		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_POSITION_INFO, params, new HashMap<>());
		return res;
	}

	public String futureContractOrder(String contractCode, String clientOrderId,
			String price, String volume, String direction, String offset, String leverRate, String orderPriceType)
			throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();		
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		if (!StringUtils.isEmpty(clientOrderId)) {
			params.put("client_order_id", clientOrderId);
		}
		if (!StringUtils.isEmpty(price)) {
			params.put("price", price);
		}
		if (!StringUtils.isEmpty(volume)) {
			params.put("volume", volume);
		}
		if (!StringUtils.isEmpty(direction)) {
			params.put("direction", direction);
		}
		if (!StringUtils.isEmpty(offset)) {
			params.put("offset", offset);
		}
		if (!StringUtils.isEmpty(leverRate)) {
			params.put("lever_rate", leverRate);
		}
		if (!StringUtils.isEmpty(orderPriceType)) {
			params.put("order_price_type", orderPriceType);
		}
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST", url_prex + HUOBI_FUTURE_ORDER,
				params, new HashMap<>());
		return res;
	}

	public String futureContractBatchorder(List<Order> orders) throws HttpException, IOException {
		Map<String, Object> params = new HashMap<>();
		params.put("orders_data", orders);
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST", url_prex + HUOBI_FUTURE_CONTRACT_BATCHORDER,
				params, new HashMap<>());
		return res;
	}

	public String futureContractCancel(String orderId, String clientOrderId,String contractCode) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(orderId)) {
			params.put("order_id", orderId);
		}
		if (!StringUtils.isEmpty(clientOrderId)) {
			params.put("client_order_id", clientOrderId);
		}
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_ORDER_CANCEL, params, new HashMap<>());
		return res;
	}

	public String futureContractCancelall(String contractCode) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}

		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_ORDER_CANCEL_ALL, params, new HashMap<>());
		return res;
	}

	public String futureContractOrderInfo(String orderId, String clientOrderId,String contractCode,String orderType) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(orderId)) {
			params.put("order_id", orderId);
		}
		if (!StringUtils.isEmpty(clientOrderId)) {
			params.put("client_order_id", clientOrderId);
		}
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		if (!StringUtils.isEmpty(orderType)) {
			params.put("order_type", orderType);
		}	
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_ORDER_INFO, params, new HashMap<>());
		return res;
	}

	public String futureContractOrderDetail(String contractCode, String orderId, String pageIndex, String pageSize,String createdAt,String orderType)
			throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		if (!StringUtils.isEmpty(orderId)) {
			params.put("order_id", orderId);
		}
		if (!StringUtils.isEmpty(pageIndex)) {
			params.put("page_index", pageIndex);
		}
		if (!StringUtils.isEmpty(pageSize)) {
			params.put("page_size", pageSize);
		}
		if (!StringUtils.isEmpty(createdAt)) {
			params.put("created_at", createdAt);
		}
		if (!StringUtils.isEmpty(orderType)) {
			params.put("order_type", orderType);
		}
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_CONTRACT_ORDER_DETAIL, params, new HashMap<>());
		return res;
	}

	public String futureContractOpenorders(String contractCode, String pageIndex, String pageSize)
			throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		if (!StringUtils.isEmpty(pageIndex)) {
			params.put("page_index", pageIndex);
		}
		if (!StringUtils.isEmpty(pageSize)) {
			params.put("page_size", pageSize);
		}
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_CONTRACE_OPENORDERS, params, new HashMap<>());
		return res;
	}

	public String futureContractHisorders(String contractCode, String tradeType, String type, String status,
			String createDate, String pageIndex, String pageSize) throws HttpException, IOException {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.isEmpty(contractCode)) {
			params.put("contract_code", contractCode);
		}
		if (!StringUtils.isEmpty(tradeType)) {
			params.put("trade_type", tradeType);
		}
		if (!StringUtils.isEmpty(type)) {
			params.put("type", type);
		}
		if (!StringUtils.isEmpty(createDate)) {
			params.put("create_date", createDate);
		}
		if (!StringUtils.isEmpty(status)) {
			params.put("status", status);
		}
		if (!StringUtils.isEmpty(pageIndex)) {
			params.put("page_index", pageIndex);
		}
		if (!StringUtils.isEmpty(pageSize)) {
			params.put("page_size", pageSize);
		}
		String res = HbdmHttpClient.getInstance().call(api_key, secret_key, "POST",
				url_prex + HUOBI_FUTURE_CONTRACT_HISORDERS, params, new HashMap<>());
		return res;
	}
}
