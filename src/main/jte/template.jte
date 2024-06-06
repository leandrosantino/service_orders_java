<!-- @import com.leandrosantino.service_orders.entity.DataPage

@param DataPage page

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ordem De serviço Preventiva, </title>
    <style>
        :root {
            --blue: #186D8D;
            --green: #16A34B;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            width: fit-content;
            height: fit-content;
        }

        * {
            margin: 0;
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12pt;
        }

        @media print {
            .buttons {
                display: none;
            }

            .buttons button {
                display: none;
            }

            .buttons div {
                display: none;
            }

            .container {
                /* margin-top: -70px; */
            }

        }

        .buttons {
            display: flex;
            justify-content: space-between;
            gap: 10px;
            align-items: center;
            margin-top: 5px;
            margin-bottom: 5px;
            width: 210mm;
            height: 50px;
        }

        .buttons div {
            font-size: 16pt;
            font-weight: 600;
        }

        .buttons div button {
            padding: 7px;
            border-radius: 6px;
            border: none;
            background-color: var(--blue);
            color: #FFF;
            font-size: 12pt;
        }

        .buttons button:hover {
            cursor: pointer;
            opacity: 90%;
        }

        .buttons button:active {
            opacity: 80%;
        }

        .buttons #_2 {
            background-color: var(--green)
        }

        .container {
            width: 210mm;
            /* min-height: 297mm; */
            /* border: 1px solid black; */
            padding: 15px;
            /* margin-bottom: 10px; */
        }

        .head {
            width: 100%;
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: space-between;
        }

        .head * {
            font-size: 16pt;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .head #logo {
            color: #000764;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        }

        .infoCase {
            margin-top: 10px;
        }

        .info {
            width: 50%;
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            border-bottom: 1px solid black;
        }

        .info div {
            width: 100%;
            padding: 3px;
        }

        .info .label {
            width: 30%;
            font-weight: bold;
        }

        .label {
            font-weight: bold;
        }

        .formCase {
            margin-top: 20px;
            display: flex;
            flex-direction: row;
            width: 100%;
        }

        .formCase .formBlock {
            display: flex;
            flex-direction: column;
            width: 50%;
        }

        .formBlock .formInput {
            display: flex;
            flex-direction: row;
            justify-content: start;
            align-items: center;
            border: 1px solid black;
            height: 40px;
            padding: 3px;
        }

        .formInput .label {
            font-size: 10pt;
            white-space: nowrap;
        }

        .formInput .value {
            text-indent: 5px;
            width: 100%;
        }

        .tableCase {
            margin-top: 15px;
            /* margin-bottom: 15px; */
            width: 100%;
        }

        .tableCase .tableHead {
            width: 100%;
            display: flex;
            flex-direction: row;
        }

        .tableCase .tableHead div {
            display: flex;
            padding: 5px;
            justify-content: start;
            align-items: center;
            background-color: rgb(180, 180, 180);
            border: 1px solid black;
            font-size: 10pt;
            font-weight: bold;
        }

        .tableCase .tableRow {
            width: 100%;
            display: flex;
            flex-direction: row;
        }

        .tableCase .tableRow div {
            display: flex;
            padding: 7px;
            justify-content: start;
            align-items: center;
            border-bottom: 1px solid black;
            font-size: 10pt;
        }

        footer{
            margin-top: 15px;
            text-align: end;
            font-size: 10px;
        }

    </style>
</head>

<body>
    <div class="container">
        <div class="head">
            <div id="logo">Adler Pelzer Group</div>
            <div>
                Ordem de Serviço Preventiva - Nº ${page.getId()}
            </div>
        </div>

        <div class="infoCase">
            <div class="info">
                <div class="label">Máquina:</div>
                <div>
                    ${page.getMachineTag()}
                </div>
            </div>
            <div class="info">
                <div class="label">Semana:</div>
                <div>
                      ${page.getWeekCode()}
                </div>
            </div>
            <div class="info">
                <div class="label">Ano:</div>
                <div>
                    ${page.getYear()}
                </div>
            </div>
 
                <div class="info">
                    <div class="label">Tempo:</div>
                    <div>
                        ${page.getDuration()} min
                    </div>
                </div>

        </div>

        <div class="formCase">
            <div class="formBlock">
                <div class="formInput">
                    <div class="label">Data:</div>
                    <div class="value"></div>
                </div>
                <div class="formInput">
                    <div class="label">Hora de Início:</div>
                    <div class="value"></div>
                </div>
                <div class="formInput">
                    <div class="label">Hora Final:</div>
                    <div class="value"></div>
                </div>
            </div>
            <div class="formBlock">
                <div class="formInput">
                    <div class="label">Especialidade:</div>
                    <div class="value">
                        ${page.getNature()}
                    </div>
                </div>
                <div class="formInput">
                    <div class="label">Manutencistas:</div>
                    <div class="value"></div>
                </div>
                <div class="formInput">
                    <div class="label">Surpevisor de Manutenção:</div>
                    <div class="value"></div>
                </div>
            </div>
        </div>

        <div class="tableCase">
            <div class="tableHead">
                <div style="width: 5%; justify-content: center;">Cod.</div>
                <div style="width: 5%; justify-content: center;">?</div>
                <div style="width: 35%;">Descrição</div>
                <div style="width: 20%;">Execução</div>
                <div style="width: 35%;">Observações</div>
            </div>

            @for(var item : page.getItens())                
                <div class="tableRow">
                    <div style="width: 5%; justify-content: center;">
                        ${item.getId()}  
                    </div>
                    <div style="width: 5%; justify-content: center;"><span style="width: 20px;">[  ]</span></div>
                    <div style="width: 35%;">
                        ${item.getDescription()}  
                    </div>
                    <div style="width: 20%;">
                        ${item.getExcution()}  
                    </div>
                    <div style="width: 35%;">
                        obs:_______________________________ __________________________________ __________________________________
                    </div>
                </div>
            @endfor

                
        </div>

        <footer>Rev 0001 anexo15 123456</footer>

    </div>
</body>

</html> -->