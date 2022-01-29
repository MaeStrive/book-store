    // Doughnut Chart 
    if ($('#pie1').length > 0) {

        var p1value = $('#pie1').data("p1value");
        var p1label = $('#pie1').data("p1label");
        var p1color = $('#pie1').data("p1color");
        
        var p1valueArray = new Array();
        var p1labelArray = new Array();
        var p1colorArray = new Array();

        p1valueArray = p1value.split(",");
        p1labelArray = p1label.split(",");
        p1colorArray = p1color.split(",");


        $(window).on('load', function(){
            var options = {
                // legend: false,
                responsive: false
            };
            new Chart($("#pie1"), {
                type: 'doughnut',
                tooltipFillColor: "rgba(51, 51, 51, 0.55)",
                data: {
                labels: p1labelArray,
                datasets: [{
                data: p1valueArray,
                backgroundColor: p1colorArray,
                hoverBackgroundColor: p1colorArray
                }]
            },
                options: { 
                    responsive: true,
                    legend: {
                            position: 'right',
                            padding: '100',
                            labels: {   
                                fontColor: '#39374A',
                                fontSize: 16,
                                padding: 20
                            }
                        }
                    }
            });           
        });
    }
            
    // Hashpower Balance Chart 
    if ($('#pie2').length > 0) {
        var p2value = $('#pie2').data("p2value");
        var p2label = $('#pie2').data("p2label");
        var p2color = $('#pie2').data("p2color");
        
        var p2valueArray = new Array();
        var p2labelArray = new Array();
        var p2colorArray = new Array();

        p2valueArray = p2value.split(",");
        p2labelArray = p2label.split(",");
        p2colorArray = p2color.split(",");

        $(window).on('load', function(){
            
            
            new Chart($("#pie2"), {
                type: 'doughnut',
                tooltipFillColor: "rgba(51, 51, 51, 0.55)",
                data: {
                labels: p2labelArray,
                datasets: [{
                data: p2valueArray,
                backgroundColor: p2colorArray,
                hoverBackgroundColor: p2colorArray
                }]
            },
                options: { 
                    responsive: true,
                    legend: {
                            position: 'right',
                            padding: '100',
                            labels: {   
                                fontColor: '#39374A',
                                fontSize: 16,
                                padding: 20
                            }
                        }
                    }
            });           
        });
    }

    // Distribution Chart
    if ($('#chart-token-distribution').length > 0) {
        $(window).on('load', function(){
            var color = Chart.helpers.color;
            var ctdxChart    = document.getElementById('chart-token-distribution').getContext('2d'),
            gradient = ctdxChart.createLinearGradient(0, 0, 0, 450);
            gradient.addColorStop(0, 'rgba(37, 73, 186, 0.5)');
            gradient.addColorStop(0.5, 'rgba(3, 216, 158, 0.25)');
            gradient.addColorStop(1, 'rgba(3, 216, 158, 0)');

            var ctdlabel = $('#chart-token-distribution').data("ctdlabel");
            
            var ctdlabelArray = new Array();

            ctdlabelArray = ctdlabel.split(",");

            new Chart($("#chart-token-distribution"), {
                
                    type: 'line',
                    data: {
                        labels: ctdlabelArray,
                        datasets: [{
                            label: '',
                            data: [
                                randomScalingFactor(),
                                randomScalingFactor(),
                                randomScalingFactor(),
                                randomScalingFactor(),
                                randomScalingFactor(),
                                randomScalingFactor(),
                                randomScalingFactor(),
                                randomScalingFactor(),
                                randomScalingFactor(),
                                randomScalingFactor(),
                                randomScalingFactor(),
                                randomScalingFactor()
                            ],
                            // backgroundColor: color(window.chartColors[colorName]).alpha(0.5).rgbString(),
                            backgroundColor: gradient,
                            borderColor: window.chartColors['green'],
                            borderWidth: 1
                        }]
                    },
                    options: {
                        responsive:true,
                        maintainAspectRatio: false,
                        legend: {
                            display: false,
                            position: 'bottom',
                        },
                        scales: {
                            xAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: false,
                                    labelString: 'Month'
                                }
                            }],
                            yAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: false,
                                    labelString: 'Value'
                                }
                            }]
                        },
                        title: {
                            display: false
                          
                        }
                    }
                   
            });           
        });
    }

    // Profile Analytics Chart
    if ($('#panalyticsChart').length > 0) {

        var ptcmonth = $('#panalyticsChart').data("ptcmonth");
        var ptcdata1 = $('#panalyticsChart').data("ptcdata1");
        var ptcdata2 = $('#panalyticsChart').data("ptcdata2");

        var ptcmonthArray = new Array();
        var ptcdata1Array = new Array();
        var ptcdata2Array = new Array();

        ptcmonthArray = ptcmonth.split(",");
        ptcdata1Array = ptcdata1.split(",");
        ptcdata2Array = ptcdata2.split(",");


        
        var pActx = document.getElementById('panalyticsChart').getContext('2d');
        var panalyticsChart = new Chart(pActx, {
            type: 'line',
            data: {
                labels: ptcmonthArray,
                datasets: [{
                    label: 'My First dataset',
                    backgroundColor: '#6D78AD',
                    borderColor: '#6D78AD',
                    data: ptcdata1Array,
                    fill: false,
                }, {
                    label: 'My Second dataset',
                    fill: false,
                    backgroundColor: '#51CDA0',
                    borderColor: '#51CDA0',
                    data: ptcdata2Array,
                }]
            },
            options: {
                responsive: true,
                title: {
                    display: true,
                    text: '2018 - 2019',
                    position: 'right',
                },
                legend: {
                    display: false,
                    position: 'top',
                },
                scales: {
                    xAxes: [{
                        gridLines: {
                            display: true,
                            drawBorder: true,
                            drawOnChartArea: false,
                        }
                    }],
                    yAxes: [{
                        gridLines: {
                            display: true,
                            drawBorder: true,
                            drawOnChartArea: false,
                        },
                        ticks: {
                            min: 0,
                            max: 200,
                            stepSize: 50
                        }
                    }]
                }
            }
        });
    }
   
    // Token By Analytics Chart
    if ($('#tokenBuyAnalyticsChart').length > 0) {

        var tbamonth = $('#tokenBuyAnalyticsChart').data("tbamonth");
        var tbadata = $('#tokenBuyAnalyticsChart').data("tbadata");

        var tbamonthArray = new Array();
        var tbadata1Array = new Array();

        tbamonthArray = tbamonth.split(",");
        tbadata1Array = tbadata.split(",");
    
        // Chart.defaults.global.legend.position="bottom";

        var lineCtx =  document.getElementById("tokenBuyAnalyticsChart");
        var myLineChart = new Chart(lineCtx, {
            type: 'line',
            data: {
            labels: tbamonthArray,
            datasets: [
                {
                    label: " ",
                    fill: true,
                    lineTension: 0.2,
                    backgroundColor: "rgba(75,192,192,0.4)",
                    borderColor: "rgba(75,192,192,1)",
                    borderCapStyle: 'butt',
                    borderDash: [],
                    borderDashOffset: 0.0,
                    borderJoinStyle: 'miter',
                    pointBorderColor: "rgba(75,192,192,1)",
                    pointBackgroundColor: "#fff",
                    pointBorderWidth: 1,
                    pointHoverRadius: 10,
                    pointHoverBackgroundColor: "rgba(255,0,0,1)",
                    pointHoverBorderColor: "rgba(255,0,0,1)",
                    pointHoverBorderWidth: 2,
                    pointRadius: 1,
                    pointHitRadius: 10,
                    data: tbadata1Array,
                    spanGaps: false,
                }
            ]
        },
            options: {
                responsive: true,
                title: {
                    display: true,
                    text: 'Token Growing Highly - 60% Yearly Revenue.',
                    position: 'top',
                },
                scales: {
                    xAxes: [{
                        gridLines: {
                            display: false,
                            drawBorder: false
                        }
                    }],
                    yAxes: [{
                        gridLines: {
                            display: false,
                            drawBorder: false
                        },
                        ticks: {
                            min: 0,
                            max: 200,
                            stepSize: 50
                        }
                    }]
                },
                legend: {
                    display: false,
                    position: 'top',
                }
            }
        });
    }

    // Recent Transaction Chart
    if ($('#myChart').length > 0) {
        
        
        var rtcdata = $('#myChart').data("rtcdata");
        var rtclabel = $('#myChart').data("rtclabel");

        var rtcdataArray = new Array();
        var rtclabelArray = new Array();

        rtcdataArray = rtcdata.split(",");
        rtclabelArray = rtclabel.split(",");


        var rtctx = document.getElementById('myChart').getContext('2d');
        var myrtChart = new Chart(rtctx, {
        type: 'bar',
        data: {
            labels: rtclabelArray,
            datasets: [{
            label: 'blue',
            data: rtcdataArray,
            backgroundColor: "#2549BA"
            }]
            
        },
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'April, 2019 History - 17 Transections',
                position: 'top',
            },
            scales: {
                xAxes: [{
                    gridLines: {
                        display: false,
                        drawBorder: false
                    }
                }],
                yAxes: [{
                    
                    ticks: {
                        min: 0,
                        max: 100,
                        stepSize: 20
                    }
                }]
            },
            legend: {
                display: false,
                position: 'top',
            }
        }
        });


    }

    // Mining Output Chart
    if ($('#miningOutputChart').length > 0) {

    
        // Chart.defaults.global.legend.position="bottom";

        var mopmonth = $('#miningOutputChart').data("mopdate");
        var mopData = $('#miningOutputChart').data("mopdata");

        var mopmonthArray = new Array();
        var mopDataArray = new Array();

        mopmonthArray = mopmonth.split(",");
        mopDataArray = mopData.split(",");



        var lineMCtx =  document.getElementById("miningOutputChart");
        var myLineMChart = new Chart(lineMCtx, {
            type: 'line',
            data: {
            labels: mopmonthArray,
            datasets: [
                {
                    label: " ",
                    fill: true,
                    lineTension: 0.2,
                    backgroundColor: "rgba(251, 187, 110, .4)",
                    borderColor: "#F79A27",
                    borderCapStyle: 'butt',
                    borderDash: [],
                    borderDashOffset: 0.0,
                    borderJoinStyle: 'miter',
                    pointBorderColor: "rgba(75,192,192,1)",
                    pointBackgroundColor: "#fff",
                    pointBorderWidth: 1,
                    pointHoverRadius: 10,
                    pointHoverBackgroundColor: "rgba(255,0,0,1)",
                    pointHoverBorderColor: "rgba(255,0,0,1)",
                    pointHoverBorderWidth: 2,
                    pointRadius: 1,
                    pointHitRadius: 10,
                    data: mopDataArray,
                    spanGaps: false,
                }
            ]
        },
            options: {
                responsive: true,
                title: {
                    display: true,
                    text: 'Output in USD',
                    position: 'top',
                },
                scales: {
                    xAxes: [{
                        gridLines: {
                            display: true,
                            drawBorder: true,
                            drawOnChartArea: false,
                        }
                    }],
                    yAxes: [{
                        gridLines: {
                            display: true,
                            drawBorder: true,
                            drawOnChartArea: false,
                        },
                        ticks: {
                            min: 0,
                            max: 5,
                            stepSize: 1
                        }
                    }]
                },
                legend: {
                    display: false,
                    position: 'top',
                }
            }
        });
    }

    if ($('#miningOutputChart2').length > 0) {

    
        // Chart.defaults.global.legend.position="bottom";
        var mop2month = $('#miningOutputChart2').data("mopdate");
        var mop2Data = $('#miningOutputChart2').data("mopdata");

        var mop2monthArray = new Array();
        var mop2DataArray = new Array();

        mop2monthArray = mop2month.split(",");
        mop2DataArray = mop2Data.split(",");





        var lineMCtx =  document.getElementById("miningOutputChart2");
        var myLineMChart = new Chart(lineMCtx, {
            type: 'line',
            data: {
            labels: mop2monthArray,
            datasets: [
                {
                    label: " ",
                    fill: true,
                    lineTension: 0.2,
                    backgroundColor: "rgba(251, 187, 110, .4)",
                    borderColor: "#F79A27",
                    borderCapStyle: 'butt',
                    borderDash: [],
                    borderDashOffset: 0.0,
                    borderJoinStyle: 'miter',
                    pointBorderColor: "rgba(75,192,192,1)",
                    pointBackgroundColor: "#fff",
                    pointBorderWidth: 1,
                    pointHoverRadius: 10,
                    pointHoverBackgroundColor: "rgba(255,0,0,1)",
                    pointHoverBorderColor: "rgba(255,0,0,1)",
                    pointHoverBorderWidth: 2,
                    pointRadius: 1,
                    pointHitRadius: 10,
                    data: mop2DataArray,
                    spanGaps: false,
                }
            ]
        },
            options: {
                responsive: true,
                title: {
                    display: true,
                    text: 'Output in USD',
                    position: 'top',
                },
                scales: {
                    xAxes: [{
                        gridLines: {
                            display: true,
                            drawBorder: true,
                            drawOnChartArea: false,
                        }
                    }],
                    yAxes: [{
                        gridLines: {
                            display: true,
                            drawBorder: true,
                            drawOnChartArea: false,
                        },
                        ticks: {
                            min: 0,
                            max: 5,
                            stepSize: 1
                        }
                    }]
                },
                legend: {
                    display: false,
                    position: 'top',
                }
            }
        });
    }

    // Wallet Chart
    if ($('#chart0').length > 0) {

        var chart0ctx = document.getElementById('chart0') || false;

        var chart0config = {
        type: 'bar',
        data: {
            labels: ['15–','20–','25–','30–','35–','40–','45–','50–','55–','60–64','65+',],
            datasets: [{
            data: [200,150,100,80,100,110,120,130,150,150,120],
            label: ' ',
            fill: false,
            backgroundColor: "#F7931A",
            //   borderColor: ['rgba(97,195,215,1)','rgba(97,195,215,1)','rgba(97,195,215,1)','rgba(97,195,215,1)','rgba(97,195,215,1)','rgba(97,195,215,1)','rgba(97,195,215,1)','rgba(97,195,215,1)','rgba(97,195,215,1)','rgba(97,195,215,1)','rgba(97,195,215,1)'],
            borderWidth: 1
            },{
            data: [220,170,120,100,120,130,140,150,170,170,140],
            label: ' ',
            fill: false,
            backgroundColor: "#F7931A",
            //   borderColor: ['rgba(157,202,114,1)','rgba(157,202,114,1)','rgba(157,202,114,1)','rgba(157,202,114,1)','rgba(157,202,114,1)','rgba(157,202,114,1)','rgba(157,202,114,1)','rgba(157,202,114,1)','rgba(157,202,114,1)','rgba(157,202,114,1)','rgba(157,202,114,1)'],
            borderWidth: 1
            }]
        },
        options: {
            title: {
            display: false,
            text: 'Analytics'
            },
            legend: {
                display: false,
                position: 'top',
            },
            scales: {
            xAxes: [{
                gridLines: {
                color: 'rgba(0,0,0,0)'
                },
                ticks: {
                beginAtZero: true
                }
            }],
            yAxes: [{
                gridLines: {
                color: 'rgba(0,0,0,.1)'
                },
                ticks: {
                beginAtZero: true
                }
            }]
            }
        }
        };

        if (chart0ctx) {
        var chart0 = new Chart(chart0ctx,chart0config);
        }

        $('#au-1').on('click', function() {
        chart0.config.data.datasets[0].data = [200,150,100,80,100,110,120,130,150,150,120];
        chart0.config.data.datasets[1].data = [220,170,120,100,120,130,140,150,170,170,140];
        chart0.config.options.title.text = 'Lorem Ipsum';
        chart0.update();
        });

        $('#au-2').on('click', function() {
        chart0.config.data.datasets[0].data = [6,8,11,12,13,14,15,18,20,22,24];
        chart0.config.data.datasets[1].data = [4,6,9,10,11,12,13,16,18,20,22];
        chart0.config.options.title.text = 'Lorem Ipsum';
        chart0.update();
        });

        $('#au-3').on('click', function() {
        chart0.config.data.datasets[0].data = [1200,1100,1000,1100,1300,1500,1800,2000,2300,2500,3200];
        chart0.config.data.datasets[1].data = [1000,900,800,900,1100,1300,1600,1800,2100,2300,3000];
        chart0.config.options.title.text = 'Lorem Ipsum';
        chart0.update();
        });
        $('#au-4').on('click', function() {
        chart0.config.data.datasets[0].data = [1100,1200,1100,1200,1200,1200,1600,2000,2300,2100,3200];
        chart0.config.data.datasets[1].data = [1000,900,800,900,1100,1300,1600,1800,2100,2300,3000];
        chart0.config.options.title.text = 'Lorem Ipsum';
        chart0.update();
        });

    
    }















    // ICO Distribution Bounce Rate
    if ($('#icoDbounceRate').length > 0) {

        var utils = Samples.utils;

        utils.srand(110);

        function alternatePointStyles(icoBrctx) {
            var index = icoBrctx.dataIndex;
            return index % 2 === 0 ? 'circle' : 'rect';
        }

        function makeHalfAsOpaque(icoBrctx) {
            var c = icoBrctx.dataset.backgroundColor;
            return utils.transparentize(c);
        }

        function adjustRadiusBasedOnData(icoBrctx) {
            var v = icoBrctx.dataset.data[icoBrctx.dataIndex];
            return v < 10 ? 5
                : v < 25 ? 7
                : v < 50 ? 9
                : v < 75 ? 11
                : 15;
        }

		var icoDbRchart = new Chart('icoDbounceRate', {
			type: 'line',
			data: {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                datasets: [{
                    data: [10,30,80,50,20,50,20,50,10,60,30,70],
                    backgroundColor: '#4dc9f6',
                    borderColor: '#4dc9f6',
                }]
            },
			options: {
                legend: false,
                tooltips: true,
                elements: {
                    line: {
                        fill: false,
                    },
                    point: {
                        hoverBackgroundColor: makeHalfAsOpaque,
                        radius: adjustRadiusBasedOnData,
                        pointStyle: alternatePointStyles,
                        hoverRadius: 15,
                    }
                },
                scales: {
                   
                    yAxes: [{
                        ticks: {
                            min: 0,
                            max: 100,
                            stepSize: 10
                        }
                    }]
                }
            }
		});


    }
















    if ($('#icosc').length > 0) {
        var icoscctx = document.getElementById('icosc').getContext('2d');

        var myChart = new Chart(icoscctx, {
            type: 'polarArea',
            data: {
                labels: ["During Pre-ICO", "During ICO", "ITOB", "Bounty", "Frozen Tokens", "Private Investors", "Directors Invest"],
                datasets: [{
                    backgroundColor: [
                        "#2ecc71",
                        "#3498db",
                        "#95a5a6",
                        "#9b59b6",
                         "#f1c40f",
                         "#e74c3c",
                         "#34495e"
                    ],
                    data: [12, 19, 3, 17, 28, 24, 7]
                }]
            },
            options: {
                
                legend: {
                    display: true,
                    position: 'bottom',
                }
            }
           
        });

		
        

    }